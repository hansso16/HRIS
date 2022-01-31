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
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Company;
import com.soses.hris.entity.Division;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.Position;
import com.soses.hris.repository.EmployeeRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeBO {

	private EmployeeRepository employeeRepo;
	
	private CompanyCacheService companyCache;
	
	private DivisionCache divisionCache;
	
	private PositionCache positionCache;
	
	@Autowired
	public EmployeeBO(EmployeeRepository employeeRepo, CompanyCacheService companyCache, DivisionCache divisionCache,
			PositionCache positionCache) {
		super();
		this.employeeRepo = employeeRepo;
		this.companyCache = companyCache;
		this.divisionCache = divisionCache;
		this.positionCache = positionCache;
	}

	public EmployeeTO retrieveEmployee(String employeeId) {
		
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		EmployeeTO employeeTO = null;
		if (employee != null) {
			employeeTO = EmployeeTransformerUtil.transformEmployeeEntity(employee);
			deriveCache(employeeTO);
		}
		return employeeTO;
	}
	
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
