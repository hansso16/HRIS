package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.dto.EmployeeInfoTO;
import com.soses.hris.dto.EmployeeTO;

/**
 * The Class AddEmployeeRequest.
 *
 * @author hso
 * @since 25 Nov 2021
 */
public class AddEmployeeRequest {

	private List<String> firstName;
	
	private String nickname;
	
	private List<EmployeeDependentTO> employeeDependentList;
	

	public List<EmployeeDependentTO> getEmployeeDependentList() {
		return employeeDependentList;
	}

	public void setEmployeeDependentList(List<EmployeeDependentTO> employeeDependentList) {
		this.employeeDependentList = employeeDependentList;
	}

	public List<String> getFirstName() {
		return firstName;
	}

	public void setFirstName(List<String> firstName) {
		this.firstName = firstName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "AddEmployeeRequest [firstName=" + firstName + ", nickname=" + nickname + ", employeeDependentList="
				+ employeeDependentList + "]";
	}
	
	
	
	
}
