package com.soses.hris.dto;

import java.time.LocalDate;

/**
 * The Class EmployeeInfo.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeInfoTO extends BaseEmployeeTO {

	/** The emergency name. */
	private String emergencyName;
	
	/** The emergency address. */
	private String emergencyAddress;
	
	/** The emergency contact. */
	private String emergencyContact;
	
	/** The mother name. */
	private String motherName;
	
	/** The mother birthdate. */
	private LocalDate motherBirthdate;
	
	/** The father name. */
	private String fatherName;
	
	/** The father birthdate. */
	private LocalDate fatherBirthdate;
	
	/**
	 * Gets the emergency name.
	 *
	 * @return the emergency name
	 */
	public String getEmergencyName() {
		return emergencyName;
	}
	
	/**
	 * Sets the emergency name.
	 *
	 * @param emergencyName the new emergency name
	 */
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	
	/**
	 * Gets the emergency address.
	 *
	 * @return the emergency address
	 */
	public String getEmergencyAddress() {
		return emergencyAddress;
	}
	
	/**
	 * Sets the emergency address.
	 *
	 * @param emergencyAddress the new emergency address
	 */
	public void setEmergencyAddress(String emergencyAddress) {
		this.emergencyAddress = emergencyAddress;
	}
	
	/**
	 * Gets the emergency contact.
	 *
	 * @return the emergency contact
	 */
	public String getEmergencyContact() {
		return emergencyContact;
	}
	
	/**
	 * Sets the emergency contact.
	 *
	 * @param emergencyContact the new emergency contact
	 */
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	/**
	 * Gets the mother name.
	 *
	 * @return the mother name
	 */
	public String getMotherName() {
		return motherName;
	}
	
	/**
	 * Sets the mother name.
	 *
	 * @param motherName the new mother name
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	
	/**
	 * Gets the mother birthdate.
	 *
	 * @return the mother birthdate
	 */
	public LocalDate getMotherBirthdate() {
		return motherBirthdate;
	}
	
	/**
	 * Sets the mother birthdate.
	 *
	 * @param motherBirthdate the new mother birthdate
	 */
	public void setMotherBirthdate(LocalDate motherBirthdate) {
		this.motherBirthdate = motherBirthdate;
	}
	
	/**
	 * Gets the father name.
	 *
	 * @return the father name
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * Sets the father name.
	 *
	 * @param fatherName the new father name
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * Gets the father birthdate.
	 *
	 * @return the father birthdate
	 */
	public LocalDate getFatherBirthdate() {
		return fatherBirthdate;
	}
	
	/**
	 * Sets the father birthdate.
	 *
	 * @param fatherBirthdate the new father birthdate
	 */
	public void setFatherBirthdate(LocalDate fatherBirthdate) {
		this.fatherBirthdate = fatherBirthdate;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeInfo [emergencyName=" + emergencyName + ", emergencyAddress=" + emergencyAddress
				+ ", emergencyContact=" + emergencyContact + ", motherName=" + motherName + ", motherBirthdate="
				+ motherBirthdate + ", fatherName=" + fatherName + ", fatherBirthdate=" + fatherBirthdate + "]";
	}
	
	
}
