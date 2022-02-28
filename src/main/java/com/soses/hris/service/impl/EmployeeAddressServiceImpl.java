package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeAddressRequest;
import com.soses.hris.api.EmployeeAddressResponse;
import com.soses.hris.cache.barangay.BarangayCache;
import com.soses.hris.cache.municipality.MunicipalCache;
import com.soses.hris.cache.province.ProvinceCache;
import com.soses.hris.cache.region.RegionCacheService;
import com.soses.hris.common.AddressTypeEnum;
import com.soses.hris.common.EmployeeAddressHelper;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.entity.Barangay;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeAddressHistory;
import com.soses.hris.entity.Municipal;
import com.soses.hris.entity.Province;
import com.soses.hris.entity.Region;
import com.soses.hris.repository.EmployeeAddressHistoryRepository;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeAddressService;

@Service("EmployeeAddressServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	private EmployeeAddressRepository employeeAddressRepo;

	private EmployeeAddressHistoryRepository employeeAddressHistoryRepo;
	
	private EmployeeRepository employeeRepo;
	
	private RegionCacheService regionCache;
	
	private ProvinceCache provinceCache;
	
	private MunicipalCache municipalCache;
	
	private BarangayCache barangayCache;
	
	@Autowired
	public EmployeeAddressServiceImpl(EmployeeAddressRepository employeeAddressRepo, EmployeeRepository employeeRepo,
			RegionCacheService regionCache, ProvinceCache provinceCache, MunicipalCache municipalCache,
			BarangayCache barangayCache, EmployeeAddressHistoryRepository employeeAddressHistoryRepo) {
		super();
		this.employeeAddressRepo = employeeAddressRepo;
		this.employeeRepo = employeeRepo;
		this.regionCache = regionCache;
		this.provinceCache = provinceCache;
		this.municipalCache = municipalCache;
		this.barangayCache = barangayCache;
		this.employeeAddressHistoryRepo = employeeAddressHistoryRepo;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {
		
		EmployeeAddressResponse resp = new EmployeeAddressResponse();
		
		List<EmployeeAddress> empAddressList = employeeAddressRepo.findByIdEmployeeId(employeeId);
		List<EmployeeAddressTO> empAddressTOList = new ArrayList<>();
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			for (EmployeeAddress empAddress : empAddressList) {
				EmployeeAddressTO empAddressTO = EmployeeTransformerUtil.transformEmployeeAddress(empAddress);
				deriveAddressCache(empAddress, empAddressTO);
				empAddressTOList.add(empAddressTO);
			}
		} else {
			if (employeeRepo.existsById(employeeId)) {
				empAddressTOList.add(new EmployeeAddressTO("1", AddressTypeEnum.valueOfAddressType("1").getAddressTypeName()));
				empAddressTOList.add(new EmployeeAddressTO("2", AddressTypeEnum.valueOfAddressType("2").getAddressTypeName()));
				empAddressTOList.add(new EmployeeAddressTO("3", AddressTypeEnum.valueOfAddressType("3").getAddressTypeName()));
			} else {
				//return error;
			}
		}
		
		
		resp.setEmployeeAddressList(empAddressTOList);
		
		return resp;
	}

	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest formReq) {

		EmployeeAddressRequest request = (EmployeeAddressRequest) formReq;
		
		List<EmployeeAddress> employeeAddressList = request.getEmployeeAddress();
		List<EmployeeAddressHistory> employeeAddressHistoryList = new ArrayList<>();
		String employeeId = request.getEmployeeId();
		boolean isSaved = false;
		if (!GeneralUtil.isListEmpty(employeeAddressList) && !StringUtil.isEmpty(employeeId)) {
			
			List<EmployeeAddress> dbEmployeeAddressList = employeeAddressRepo.findByIdEmployeeId(employeeId);
			if (!GeneralUtil.isListEmpty(dbEmployeeAddressList)) {
				for (int i = 0; i < dbEmployeeAddressList.size(); i++) {
					EmployeeAddress dbEmpAddress = dbEmployeeAddressList.get(i);
					if (EmployeeAddressHelper.isChanged(dbEmpAddress, employeeAddressList.get(i))) {
						// create employee address history
						EmployeeAddressHistory employeeAddressHistory = EmployeeAddressHelper.convertToEmpAddressHistory(dbEmpAddress);
						employeeAddressHistoryList.add(employeeAddressHistory);
					}
				}
				
				if (!GeneralUtil.isListEmpty(employeeAddressHistoryList)) {
					employeeAddressHistoryRepo.saveAll(employeeAddressHistoryList);
				}
			}
			
			employeeAddressList = employeeAddressRepo.saveAll(employeeAddressList);
			isSaved = true;
		}

		return isSaved;
	}
	
	private void deriveAddressCache(EmployeeAddress empAddress, EmployeeAddressTO empAddressTO) {
		if (empAddressTO != null && empAddressTO != null) {
			Region region = empAddress.getRegion();
			if (region != null) {
				empAddressTO.setRegionList(regionCache.findAll());
				Province province = empAddress.getProvince();
				if(province != null) {
					empAddressTO.setProvinceList(provinceCache.getProvinceListByRegion(region.getRegionId()));
					Municipal municipal = empAddress.getMunicipal();
					if (municipal != null) {
						empAddressTO.setMunicipalList(municipalCache.getMunicipalListByProvince(province.getProvinceId()));
						Barangay barangay = empAddress.getBarangay();
						if (barangay != null) {
							empAddressTO.setBarangayList(barangayCache.getBarangayListByMunicipal(municipal.getMunicipalId()));
						}
					}
				}
			}
		}
	}
}
