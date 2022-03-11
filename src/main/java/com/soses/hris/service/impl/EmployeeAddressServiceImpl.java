package com.soses.hris.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeAddressRequest;
import com.soses.hris.api.EmployeeAddressResponse;
import com.soses.hris.cache.barangay.BarangayCache;
import com.soses.hris.cache.municipality.MunicipalCache;
import com.soses.hris.cache.province.ProvinceCache;
import com.soses.hris.cache.region.RegionCacheService;
import com.soses.hris.common.ActivityHistoryConstants;
import com.soses.hris.common.AddressTypeEnum;
import com.soses.hris.common.EmployeeAddressHelper;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.entity.ActivityHistory;
import com.soses.hris.entity.Barangay;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeAddressHistory;
import com.soses.hris.entity.Municipal;
import com.soses.hris.entity.Province;
import com.soses.hris.entity.Region;
import com.soses.hris.repository.EmployeeAddressHistoryRepository;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.ActivityHistoryService;
import com.soses.hris.service.EmployeeAddressService;

/**
 * The Class EmployeeAddressServiceImpl.
 *
 * @author hso
 * @since Mar 10, 2022
 */
@Service("EmployeeAddressServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	/** The employee address repo. */
	private EmployeeAddressRepository employeeAddressRepo;

	/** The employee address history repo. */
	private EmployeeAddressHistoryRepository employeeAddressHistoryRepo;
	
	/** The employee repo. */
	private EmployeeRepository employeeRepo;
	
	/** The region cache. */
	private RegionCacheService regionCache;
	
	/** The province cache. */
	private ProvinceCache provinceCache;
	
	/** The municipal cache. */
	private MunicipalCache municipalCache;
	
	/** The barangay cache. */
	private BarangayCache barangayCache;
	
	/** The activity history service. */
	private ActivityHistoryService activityHistoryService;
	
	/**
	 * Instantiates a new employee address service impl.
	 *
	 * @param employeeAddressRepo the employee address repo
	 * @param employeeRepo the employee repo
	 * @param regionCache the region cache
	 * @param provinceCache the province cache
	 * @param municipalCache the municipal cache
	 * @param barangayCache the barangay cache
	 * @param employeeAddressHistoryRepo the employee address history repo
	 * @param activityHistoryService the activity history service
	 */
	@Autowired
	public EmployeeAddressServiceImpl(EmployeeAddressRepository employeeAddressRepo, EmployeeRepository employeeRepo,
			RegionCacheService regionCache, ProvinceCache provinceCache, MunicipalCache municipalCache,
			BarangayCache barangayCache, EmployeeAddressHistoryRepository employeeAddressHistoryRepo
			, ActivityHistoryService activityHistoryService) {
		super();
		this.employeeAddressRepo = employeeAddressRepo;
		this.employeeRepo = employeeRepo;
		this.regionCache = regionCache;
		this.provinceCache = provinceCache;
		this.municipalCache = municipalCache;
		this.barangayCache = barangayCache;
		this.employeeAddressHistoryRepo = employeeAddressHistoryRepo;
		this.activityHistoryService = activityHistoryService;
	}

	/**
	 * Gets the employee details.
	 *
	 * @param employeeId the employee id
	 * @return the employee details
	 */
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

	/**
	 * Update employee details.
	 *
	 * @param formReq the form req
	 * @return true, if successful
	 */
	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest formReq) {

		EmployeeAddressRequest request = (EmployeeAddressRequest) formReq;
		
		List<EmployeeAddress> employeeAddressList = request.getEmployeeAddress();
		List<EmployeeAddressHistory> employeeAddressHistoryList = new ArrayList<>();
		List<ActivityHistory> activityList = new ArrayList<>();
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

						StringBuilder sb = new StringBuilder();
						sb.append(AddressTypeEnum.deriveAddressType(employeeAddressHistory.getId().getAddressType()));
						sb.append(GlobalConstants.EMPTY_SPACE);
						sb.append(ActivityHistoryConstants.IS_UPDATED);
						String activityText = sb.toString();

						ActivityHistory activityHistory = new ActivityHistory();
						activityHistory.setEmployeeId(employeeId);
						activityHistory.setActivityText(activityText);
						activityHistory.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
						activityHistory.setEntryTimestamp(LocalDateTime.now());
						activityList.add(activityHistory);
					}
				}
				
				if (!GeneralUtil.isListEmpty(employeeAddressHistoryList)) {
					employeeAddressHistoryRepo.saveAll(employeeAddressHistoryList);
				}
			}
			
			employeeAddressList = employeeAddressRepo.saveAll(employeeAddressList);
			activityHistoryService.saveAll(activityList);
			
			isSaved = true;
		}

		return isSaved;
	}
	
	/**
	 * Derive address cache.
	 *
	 * @param empAddress the emp address
	 * @param empAddressTO the emp address TO
	 */
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
