package com.soses.hris.api.user;

import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.dto.UserTO;
import com.soses.hris.entity.Company;
import com.soses.hris.entity.Division;
import com.soses.hris.entity.Position;

/**
 * The Class UserResponse.
 *
 * @author hso
 * @since Mar 22, 2022
 */
public class UserResponse extends BaseUserResponse {

	/** The user. */
	private UserTO user;
	
	/** The employee. */
	private EmployeeTO employee;
	
	/** The company. */
	private Company company;
	
	/** The division. */
	private Division division;
	
	/** The position. */
	private Position position;

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public UserTO getUser() {
		return user;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public EmployeeTO getEmployee() {
		return employee;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * Gets the division.
	 *
	 * @return the division
	 */
	public Division getDivision() {
		return division;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(UserTO user) {
		this.user = user;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(EmployeeTO employee) {
		this.employee = employee;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Sets the division.
	 *
	 * @param division the new division
	 */
	public void setDivision(Division division) {
		this.division = division;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
