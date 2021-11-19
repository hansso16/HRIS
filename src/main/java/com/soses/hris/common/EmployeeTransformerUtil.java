package com.soses.hris.common;

import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeBenefits;

public class EmployeeTransformerUtil {

	public static EmployeeTO transformEmployeeEntity(Employee employee) {
		EmployeeTO employeeTO = null;
		if (employee != null) {
			employeeTO = new EmployeeTO();
			employeeTO.setEmployeeId(employee.getEmployeeId());
			employeeTO.setLastName(employee.getLastName());
			employeeTO.setFirstName(employee.getFirstName());
			employeeTO.setMiddleName(employee.getMiddleName());
			employeeTO.setSuffix(employee.getSuffix());
			employeeTO.setNickname(employee.getNickname());
			employeeTO.setCellNo(employee.getCellNo());
			employeeTO.setTeleNo(employee.getTelNo());
			employeeTO.setEmailAddress(employee.getEmailAddress());
			employeeTO.setGender(employee.getGender()); //derive
			employeeTO.setBirthdate(employee.getBirthdate()); //date format
			employeeTO.setMaritalStatus(employee.getMaritalStatus()); //derive
			employeeTO.setHiringDate(employee.getHiringDate()); //date format
			employeeTO.setTerminationDate(employee.getTerminationDate()); //date format
			employeeTO.setRegularizationDate(employee.getRegularizationDate()); //date format
			employeeTO.setDivision(employee.getDivision()); // derive
			employeeTO.setPosition(employee.getPosition()); // derive
		}
		
		return employeeTO;
	}
	
	public static EmployeeAddressTO transformEmployeeAddress(EmployeeAddress empAddress) {
		EmployeeAddressTO employeeAddressTO = null;
		if (empAddress != null) {
			employeeAddressTO = new EmployeeAddressTO();
			employeeAddressTO.setEmployeeId(empAddress.getId().getEmployeeId());
			employeeAddressTO.setAddressType(empAddress.getId().getAddressType()); // derive
			employeeAddressTO.setStreet(empAddress.getStreet());
			employeeAddressTO.setBarangay(empAddress.getBarangay());
			employeeAddressTO.setCity(empAddress.getCity());
			employeeAddressTO.setProvince(empAddress.getProvince());
		}
	
		return employeeAddressTO;
	}
	
	public static EmployeeBenefitsTO transformEmployeeBenefits(EmployeeBenefits empBenefits) {
		EmployeeBenefitsTO employeeBenefitsTO = null;
		if (empBenefits != null) {
			employeeBenefitsTO = new EmployeeBenefitsTO();
			employeeBenefitsTO.setEmployeeId(empBenefits.getEmployeeId());
			employeeBenefitsTO.setPagibigMembershipDate(empBenefits.getPagibigMembershipDate());
			employeeBenefitsTO.setPagibigNo(empBenefits.getPagibigNo());
			employeeBenefitsTO.setPhilHealthMembershipDate(empBenefits.getPhilhealthMembershipDate());
			employeeBenefitsTO.setPhilHealthNo(empBenefits.getPhilhealthNo());
			employeeBenefitsTO.setSssMembershipDate(empBenefits.getSssMembershipDate());
			employeeBenefitsTO.setSssNo(empBenefits.getSssNo());
			employeeBenefitsTO.setTinNo(empBenefits.getTinNo());
		}
	
		return employeeBenefitsTO;
	}
}
