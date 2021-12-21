package com.soses.hris.api;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The Class AddEmployeeRequest.
 *
 * @author hso
 * @since 25 Nov 2021
 */
public class AddEmployeeRequest {

	// Employee
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The suffix. */
	private String suffix;
	
	/** The middle name. */
	private String middleName;
	
	/** The nickname. */
	private String nickname;
	
	/** The cell no. */
	private String cellNo;
	
	/** The tel no. */
	private String telNo;
	
	/** The email address. */
	private String emailAddress;
	
	/** The gender. */
	private String gender;
	
	/** The birthdate. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birthdate;
	
	/** The marital status. */
	private String maritalStatus;
	
	/** The hiring date. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate hiringDate;
	
	/** The division. */
	private String division;
	
	/** The position. */
	private String position;
	
	// Employee Address
	/** The present province. */
	private String presentProvince;
	
	/** The present city. */
	private String presentCity;
	
	/** The present barangay. */
	private String presentBarangay;
	
	/** The present street. */
	private String presentStreet;

	/** The permanent province. */
	private String permanentProvince;
	
	/** The permanent city. */
	private String permanentCity;
	
	/** The permanent barangay. */
	private String permanentBarangay;
	
	/** The permanent street. */
	private String permanentStreet;

	/** The provincial province. */
	private String provincialProvince;
	
	/** The provincial city. */
	private String provincialCity;
	
	/** The provincial barangay. */
	private String provincialBarangay;
	
	/** The provincial street. */
	private String provincialStreet;
	
	// Emergency Contact
	/** The emergency name. */
	private String emergencyName;
	
	/** The emergency address. */
	private String emergencyAddress;
	
	/** The emergency contact. */
	private String emergencyContact;
	
	// Family Info
	/** The father name. */
	private String fatherName;
	
	/** The father birthdate. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fatherBirthdate;
	
	/** The mother name. */
	private String motherName;
	
	/** The mother birthdate. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate motherBirthdate;
	
	// Employee Dependent
	/** The dep name. */
	private String depName;
	
	/** The dep gender. */
	private String depGender;
	
	// Employee Benefits
	/** The sss no. */
	private String sssNo;
	
	/** The sss membership date. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate sssMembershipDate;
	
	/** The phil health no. */
	private String philHealthNo;
	
	/** The phil health membership date. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate philHealthMembershipDate;
	
	/** The pagibig no. */
	private String pagibigNo;
	
	/** The pagibig membership date. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate pagibigMembershipDate;
	
	/** The tin no. */
	private String tinNo;

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the suffix.
	 *
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Gets the cell no.
	 *
	 * @return the cell no
	 */
	public String getCellNo() {
		return cellNo;
	}

	/**
	 * Gets the tel no.
	 *
	 * @return the tel no
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
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
	 * Gets the birthdate.
	 *
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * Gets the marital status.
	 *
	 * @return the marital status
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Gets the hiring date.
	 *
	 * @return the hiring date
	 */
	public LocalDate getHiringDate() {
		return hiringDate;
	}

	/**
	 * Gets the division.
	 *
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Gets the present province.
	 *
	 * @return the present province
	 */
	public String getPresentProvince() {
		return presentProvince;
	}

	/**
	 * Gets the present city.
	 *
	 * @return the present city
	 */
	public String getPresentCity() {
		return presentCity;
	}

	/**
	 * Gets the present barangay.
	 *
	 * @return the present barangay
	 */
	public String getPresentBarangay() {
		return presentBarangay;
	}

	/**
	 * Gets the present street.
	 *
	 * @return the present street
	 */
	public String getPresentStreet() {
		return presentStreet;
	}

	/**
	 * Gets the permanent province.
	 *
	 * @return the permanent province
	 */
	public String getPermanentProvince() {
		return permanentProvince;
	}

	/**
	 * Gets the permanent city.
	 *
	 * @return the permanent city
	 */
	public String getPermanentCity() {
		return permanentCity;
	}

	/**
	 * Gets the permanent barangay.
	 *
	 * @return the permanent barangay
	 */
	public String getPermanentBarangay() {
		return permanentBarangay;
	}

	/**
	 * Gets the permanent street.
	 *
	 * @return the permanent street
	 */
	public String getPermanentStreet() {
		return permanentStreet;
	}

	/**
	 * Gets the provincial province.
	 *
	 * @return the provincial province
	 */
	public String getProvincialProvince() {
		return provincialProvince;
	}

	/**
	 * Gets the provincial city.
	 *
	 * @return the provincial city
	 */
	public String getProvincialCity() {
		return provincialCity;
	}

	/**
	 * Gets the provincial barangay.
	 *
	 * @return the provincial barangay
	 */
	public String getProvincialBarangay() {
		return provincialBarangay;
	}

	/**
	 * Gets the provincial street.
	 *
	 * @return the provincial street
	 */
	public String getProvincialStreet() {
		return provincialStreet;
	}

	/**
	 * Gets the emergency name.
	 *
	 * @return the emergency name
	 */
	public String getEmergencyName() {
		return emergencyName;
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
	 * Gets the emergency contact.
	 *
	 * @return the emergency contact
	 */
	public String getEmergencyContact() {
		return emergencyContact;
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
	 * Gets the father birthdate.
	 *
	 * @return the father birthdate
	 */
	public LocalDate getFatherBirthdate() {
		return fatherBirthdate;
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
	 * Gets the mother birthdate.
	 *
	 * @return the mother birthdate
	 */
	public LocalDate getMotherBirthdate() {
		return motherBirthdate;
	}

	/**
	 * Gets the dep name.
	 *
	 * @return the dep name
	 */
	public String getDepName() {
		return depName;
	}

	/**
	 * Gets the dep gender.
	 *
	 * @return the dep gender
	 */
	public String getDepGender() {
		return depGender;
	}

	/**
	 * Gets the sss no.
	 *
	 * @return the sss no
	 */
	public String getSssNo() {
		return sssNo;
	}

	/**
	 * Gets the sss membership date.
	 *
	 * @return the sss membership date
	 */
	public LocalDate getSssMembershipDate() {
		return sssMembershipDate;
	}

	/**
	 * Gets the phil health no.
	 *
	 * @return the phil health no
	 */
	public String getPhilHealthNo() {
		return philHealthNo;
	}

	/**
	 * Gets the phil health membership date.
	 *
	 * @return the phil health membership date
	 */
	public LocalDate getPhilHealthMembershipDate() {
		return philHealthMembershipDate;
	}

	/**
	 * Gets the pagibig no.
	 *
	 * @return the pagibig no
	 */
	public String getPagibigNo() {
		return pagibigNo;
	}

	/**
	 * Gets the pagibig membership date.
	 *
	 * @return the pagibig membership date
	 */
	public LocalDate getPagibigMembershipDate() {
		return pagibigMembershipDate;
	}

	/**
	 * Gets the tin no.
	 *
	 * @return the tin no
	 */
	public String getTinNo() {
		return tinNo;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the suffix.
	 *
	 * @param suffix the new suffix
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Sets the nickname.
	 *
	 * @param nickname the new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Sets the cell no.
	 *
	 * @param cellNo the new cell no
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	/**
	 * Sets the tel no.
	 *
	 * @param telNo the new tel no
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	 * Sets the birthdate.
	 *
	 * @param birthdate the new birthdate
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Sets the marital status.
	 *
	 * @param maritalStatus the new marital status
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Sets the hiring date.
	 *
	 * @param hiringDate the new hiring date
	 */
	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	/**
	 * Sets the division.
	 *
	 * @param division the new division
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Sets the present province.
	 *
	 * @param presentProvince the new present province
	 */
	public void setPresentProvince(String presentProvince) {
		this.presentProvince = presentProvince;
	}

	/**
	 * Sets the present city.
	 *
	 * @param presentCity the new present city
	 */
	public void setPresentCity(String presentCity) {
		this.presentCity = presentCity;
	}

	/**
	 * Sets the present barangay.
	 *
	 * @param presentBarangay the new present barangay
	 */
	public void setPresentBarangay(String presentBarangay) {
		this.presentBarangay = presentBarangay;
	}

	/**
	 * Sets the present street.
	 *
	 * @param presentStreet the new present street
	 */
	public void setPresentStreet(String presentStreet) {
		this.presentStreet = presentStreet;
	}

	/**
	 * Sets the permanent province.
	 *
	 * @param permanentProvince the new permanent province
	 */
	public void setPermanentProvince(String permanentProvince) {
		this.permanentProvince = permanentProvince;
	}

	/**
	 * Sets the permanent city.
	 *
	 * @param permanentCity the new permanent city
	 */
	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	/**
	 * Sets the permanent barangay.
	 *
	 * @param permanentBarangay the new permanent barangay
	 */
	public void setPermanentBarangay(String permanentBarangay) {
		this.permanentBarangay = permanentBarangay;
	}

	/**
	 * Sets the permanent street.
	 *
	 * @param permanentStreet the new permanent street
	 */
	public void setPermanentStreet(String permanentStreet) {
		this.permanentStreet = permanentStreet;
	}

	/**
	 * Sets the provincial province.
	 *
	 * @param provincialProvince the new provincial province
	 */
	public void setProvincialProvince(String provincialProvince) {
		this.provincialProvince = provincialProvince;
	}

	/**
	 * Sets the provincial city.
	 *
	 * @param provincialCity the new provincial city
	 */
	public void setProvincialCity(String provincialCity) {
		this.provincialCity = provincialCity;
	}

	/**
	 * Sets the provincial barangay.
	 *
	 * @param provincialBarangay the new provincial barangay
	 */
	public void setProvincialBarangay(String provincialBarangay) {
		this.provincialBarangay = provincialBarangay;
	}

	/**
	 * Sets the provincial street.
	 *
	 * @param provincialStreet the new provincial street
	 */
	public void setProvincialStreet(String provincialStreet) {
		this.provincialStreet = provincialStreet;
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
	 * Sets the emergency address.
	 *
	 * @param emergencyAddress the new emergency address
	 */
	public void setEmergencyAddress(String emergencyAddress) {
		this.emergencyAddress = emergencyAddress;
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
	 * Sets the father name.
	 *
	 * @param fatherName the new father name
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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
	 * Sets the mother name.
	 *
	 * @param motherName the new mother name
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
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
	 * Sets the dep name.
	 *
	 * @param depName the new dep name
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}

	/**
	 * Sets the dep gender.
	 *
	 * @param depGender the new dep gender
	 */
	public void setDepGender(String depGender) {
		this.depGender = depGender;
	}

	/**
	 * Sets the sss no.
	 *
	 * @param sssNo the new sss no
	 */
	public void setSssNo(String sssNo) {
		this.sssNo = sssNo;
	}

	/**
	 * Sets the sss membership date.
	 *
	 * @param sssMembershipDate the new sss membership date
	 */
	public void setSssMembershipDate(LocalDate sssMembershipDate) {
		this.sssMembershipDate = sssMembershipDate;
	}

	/**
	 * Sets the phil health no.
	 *
	 * @param philHealthNo the new phil health no
	 */
	public void setPhilHealthNo(String philHealthNo) {
		this.philHealthNo = philHealthNo;
	}

	/**
	 * Sets the phil health membership date.
	 *
	 * @param philHealthMembershipDate the new phil health membership date
	 */
	public void setPhilHealthMembershipDate(LocalDate philHealthMembershipDate) {
		this.philHealthMembershipDate = philHealthMembershipDate;
	}

	/**
	 * Sets the pagibig no.
	 *
	 * @param pagibigNo the new pagibig no
	 */
	public void setPagibigNo(String pagibigNo) {
		this.pagibigNo = pagibigNo;
	}

	/**
	 * Sets the pagibig membership date.
	 *
	 * @param pagibigMembershipDate the new pagibig membership date
	 */
	public void setPagibigMembershipDate(LocalDate pagibigMembershipDate) {
		this.pagibigMembershipDate = pagibigMembershipDate;
	}

	/**
	 * Sets the tin no.
	 *
	 * @param tinNo the new tin no
	 */
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AddEmployeeRequest [firstName=" + firstName + ", lastName=" + lastName + ", suffix=" + suffix
				+ ", middleName=" + middleName + ", nickname=" + nickname + ", cellNo=" + cellNo + ", telNo=" + telNo
				+ ", emailAddress=" + emailAddress + ", gender=" + gender + ", birthdate=" + birthdate
				+ ", maritalStatus=" + maritalStatus + ", hiringDate=" + hiringDate + ", division=" + division
				+ ", position=" + position + ", presentProvince=" + presentProvince + ", presentCity=" + presentCity
				+ ", presentBarangay=" + presentBarangay + ", presentStreet=" + presentStreet + ", permanentProvince="
				+ permanentProvince + ", permanentCity=" + permanentCity + ", permanentBarangay=" + permanentBarangay
				+ ", permanentStreet=" + permanentStreet + ", provincialProvince=" + provincialProvince
				+ ", provincialCity=" + provincialCity + ", provincialBarangay=" + provincialBarangay
				+ ", provincialStreet=" + provincialStreet + ", emergencyName=" + emergencyName + ", emergencyAddress="
				+ emergencyAddress + ", emergencyContact=" + emergencyContact + ", fatherName=" + fatherName
				+ ", fatherBirthdate=" + fatherBirthdate + ", motherName=" + motherName + ", motherBirthdate="
				+ motherBirthdate + ", depName=" + depName + ", depGender=" + depGender + ", sssNo=" + sssNo
				+ ", sssMembershipDate=" + sssMembershipDate + ", philHealthNo=" + philHealthNo
				+ ", philHealthMembershipDate=" + philHealthMembershipDate + ", pagibigNo=" + pagibigNo
				+ ", pagibigMembershipDate=" + pagibigMembershipDate + ", tinNo=" + tinNo + "]";
	}
}
