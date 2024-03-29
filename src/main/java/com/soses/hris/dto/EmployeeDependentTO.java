package com.soses.hris.dto;

import java.time.LocalDate;

/**
 * The Class EmployeeDependent.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeDependentTO extends BaseEmployeeTO {

	/** The dependent id. */
	private int dependentId;
	
	/** The dependent name. */
	private String dependentName;
	
	/** The dependent birthdate. */
	private LocalDate dependentBirthdate;
	
	/** The gender. */
	private String gender;
	
	/** The dependent relationship. */
	private String dependentRelationship;

	/**
	 * Gets the dependent relationship.
	 *
	 * @return the dependent relationship
	 */
	public String getDependentRelationship() {
		return dependentRelationship;
	}

	/**
	 * Sets the dependent relationship.
	 *
	 * @param dependentRelationship the new dependent relationship
	 */
	public void setDependentRelationship(String dependentRelationship) {
		this.dependentRelationship = dependentRelationship;
	}

	/**
	 * Sets the dependent birthdate.
	 *
	 * @param dependentBirthdate the new dependent birthdate
	 */
	public void setDependentBirthdate(LocalDate dependentBirthdate) {
		this.dependentBirthdate = dependentBirthdate;
	}
	
	/**
	 * Gets the dependent id.
	 *
	 * @return the dependent id
	 */
	public int getDependentId() {
		return dependentId;
	}
	
	/**
	 * Sets the dependent id.
	 *
	 * @param dependentId the new dependent id
	 */
	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}
	
	/**
	 * Gets the dependent birthdate.
	 *
	 * @return the dependent birthdate
	 */
	public LocalDate getDependentBirthdate() {
		return dependentBirthdate;
	}

	/**
	 * Gets the dependent name.
	 *
	 * @return the dependent name
	 */
	public String getDependentName() {
		return dependentName;
	}
	
	/**
	 * Sets the dependent name.
	 *
	 * @param dependentName the new dependent name
	 */
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeDependentTO [dependentId=" + dependentId + ", dependentName=" + dependentName
				+ ", dependentBirthdate=" + dependentBirthdate + ", gender=" + gender + ", dependentRelationship="
				+ dependentRelationship + "]";
	}
	
	
}
