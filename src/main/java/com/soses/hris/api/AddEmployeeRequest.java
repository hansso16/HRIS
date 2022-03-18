package com.soses.hris.api;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.soses.hris.entity.Employee;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeInfo;

/**
 * The Class AddEmployeeRequest.
 *
 * @author hso
 * @since 25 Nov 2021
 */
public class AddEmployeeRequest {

	/** The employee. */
	private Employee employee;
	
	/** The employee address. */
	private List<EmployeeAddress> employeeAddress;
	
	/** The employee info. */
	private EmployeeInfo employeeInfo;
	
	/** The employee dependent. */
	private List<EmployeeDependent> employeeDependent;
	
	/** The employee benefits. */
	private EmployeeBenefits employeeBenefits;
	
	/** The file. */
	private MultipartFile file;
	
	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the new file
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 *  The employee dependent.
	 *
	 * @return the employee
	 */

	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Gets the employee address.
	 *
	 * @return the employee address
	 */
	public List<EmployeeAddress> getEmployeeAddress() {
		return employeeAddress;
	}
	
	/**
	 * Gets the employee info.
	 *
	 * @return the employee info
	 */
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}
	
	/**
	 * Gets the employee benefits.
	 *
	 * @return the employee benefits
	 */
	public EmployeeBenefits getEmployeeBenefits() {
		return employeeBenefits;
	}
	
	/**
	 * Gets the employee dependent.
	 *
	 * @return the employee dependent
	 */
	public List<EmployeeDependent> getEmployeeDependent() {
		return employeeDependent;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Sets the employee address.
	 *
	 * @param employeeAddress the new employee address
	 */
	public void setEmployeeAddress(List<EmployeeAddress> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	/**
	 * Sets the employee info.
	 *
	 * @param employeeInfo the new employee info
	 */
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	
	/**
	 * Sets the employee benefits.
	 *
	 * @param employeeBenefits the new employee benefits
	 */
	public void setEmployeeBenefits(EmployeeBenefits employeeBenefits) {
		this.employeeBenefits = employeeBenefits;
	}
	
	/**
	 * Sets the employee dependent.
	 *
	 * @param employeeDependent the new employee dependent
	 */
	public void setEmployeeDependent(List<EmployeeDependent> employeeDependent) {
		this.employeeDependent = employeeDependent;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AddEmployeeRequest [employee=" + employee + ", employeeAddress=" + employeeAddress + ", employeeInfo="
				+ employeeInfo + ", employeeBenefits=" + employeeBenefits + ", employeeDependent=" + employeeDependent
				+ "]";
	}
	
}
