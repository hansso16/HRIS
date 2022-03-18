package com.soses.hris.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.cache.company.CompanyCacheService;
import com.soses.hris.cache.division.DivisionCache;
import com.soses.hris.cache.position.PositionCache;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.FlatFileService;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Company;
import com.soses.hris.entity.Division;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.Position;
import com.soses.hris.repository.EmployeeRepository;

/**
 * The Class EmployeeBO.
 *
 * @author hso
 * @since Mar 17, 2022
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeBO {

	/** The employee repo. */
	private EmployeeRepository employeeRepo;
	
	/** The company cache. */
	private CompanyCacheService companyCache;
	
	/** The division cache. */
	private DivisionCache divisionCache;
	
	/** The position cache. */
	private PositionCache positionCache;
	
	/** The flat file util. */
	private FlatFileService flatFileUtil;
	
	/**
	 * Instantiates a new employee BO.
	 *
	 * @param employeeRepo the employee repo
	 * @param companyCache the company cache
	 * @param divisionCache the division cache
	 * @param positionCache the position cache
	 * @param flatFileUtil the flat file util
	 */
	@Autowired
	public EmployeeBO(EmployeeRepository employeeRepo, CompanyCacheService companyCache, DivisionCache divisionCache,
			PositionCache positionCache, FlatFileService flatFileUtil) {
		super();
		this.employeeRepo = employeeRepo;
		this.companyCache = companyCache;
		this.divisionCache = divisionCache;
		this.positionCache = positionCache;
		this.flatFileUtil = flatFileUtil;
	}

	/**
	 * Retrieve employee.
	 *
	 * @param employeeId the employee id
	 * @return the employee TO
	 */
	public EmployeeTO retrieveEmployee(String employeeId) {
		
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		EmployeeTO employeeTO = null;
		if (employee != null) {
			employeeTO = EmployeeTransformerUtil.transformEmployeeEntity(employee);
			employeeTO.setEmpPhotoBase64(flatFileUtil.generateBase64ImgString(employee.getPhoto()));
			deriveCache(employeeTO);
		}
		return employeeTO;
	}
	
	/**
	 * Derive cache.
	 *
	 * @param employeeTO the employee TO
	 */
	private void deriveCache(EmployeeTO employeeTO) {
		if (employeeTO != null) {
			List<Company> companyList = companyCache.findAll();
			employeeTO.setCompanyList(companyList);
			String companyCode = employeeTO.getCompanyCode();
			if (!StringUtil.isEmpty(companyCode)) {
				List<Division> divisionList = divisionCache.getDivisionListByCompany(companyCode);
				employeeTO.setDivisionList(divisionList);
				String divisionCode = employeeTO.getDivisionCode();
				if (!StringUtil.isEmpty(divisionCode)) {
					List<Position> positionList = positionCache.getPositionListByDivision(divisionCode);
					employeeTO.setPositionList(positionList);
				}
			}
		}
	}
}
