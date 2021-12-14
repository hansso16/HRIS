package com.soses.hris.common;

import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.dto.EmployeeInfoTO;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeInfo;

/**
 * The Class EmployeeTransformerUtil.
 *
 * @author hso
 * @since 23 Nov 2021
 */
public class EmployeeTransformerUtil {
	
	/**
	 * Transform employee dependent entity.
	 *
	 * @param employeeDependent the employee dependent
	 * @return the employee dependent TO
	 */
	public static EmployeeDependentTO transformEmployeeDependentEntity(EmployeeDependent employeeDependent) {
		EmployeeDependentTO employeeDependentTO = null;
		if (employeeDependent != null) {
			employeeDependentTO = new EmployeeDependentTO();
			employeeDependentTO.setDependentBirthdate(employeeDependent.getDependentBirthdate());
			employeeDependentTO.setDependentId(employeeDependent.getId().getDependentId());
			employeeDependentTO.setDependentName(employeeDependent.getDependentName());
			employeeDependentTO.setGender(employeeDependent.getGender());
			employeeDependentTO.setEmployeeId(employeeDependent.getId().getEmployeeId());
		}
		
		return employeeDependentTO;
	}
	
	/**
	 * Transform employee info entity.
	 *
	 * @param employeeInfo the employee info
	 * @return the employee info TO
	 */
	public static EmployeeInfoTO transformEmployeeInfoEntity(EmployeeInfo employeeInfo) {
		EmployeeInfoTO employeeInfoTO = null;
		if (employeeInfo != null) {
			employeeInfoTO = new EmployeeInfoTO();
			employeeInfoTO.setEmergencyName(employeeInfo.getEmergencyName());
			employeeInfoTO.setEmergencyAddress(employeeInfo.getEmergencyAddress());
			employeeInfoTO.setEmergencyContact(employeeInfo.getEmergencyContact());
			employeeInfoTO.setFatherBirthdate(employeeInfo.getFatherBirthdate());
			employeeInfoTO.setFatherName(employeeInfo.getFatherName());
			employeeInfoTO.setMotherBirthdate(employeeInfo.getMotherBirthdate());
			employeeInfoTO.setMotherName(employeeInfo.getMotherName());
		}
		
		return employeeInfoTO;
	}

	/**
	 * Transform employee entity.
	 *
	 * @param employee the employee
	 * @return the employee TO
	 */
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
	
	/**
	 * Transform employee address.
	 *
	 * @param empAddress the emp address
	 * @return the employee address TO
	 */
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
	
	/**
	 * Transform employee benefits.
	 *
	 * @param empBenefits the emp benefits
	 * @return the employee benefits TO
	 */
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