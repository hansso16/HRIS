package com.soses.hris.api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.soses.hris.dto.EmployeeAddressTO;

public class UpdateRequest extends BaseEmployeeRequest {

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
	private EmployeeAddressTO[] employeeAddressArr;
	
	private List<EmployeeAddressTO> employeeAddressList;
	
	private String street;
	
	private String barangay;
	
	private String city;
	
	private String province;
	
	
	
	
	public EmployeeAddressTO[] getEmployeeAddressArr() {
		return employeeAddressArr;
	}

	public List<EmployeeAddressTO> getEmployeeAddressList() {
		return employeeAddressList;
	}

	public void setEmployeeAddressArr(EmployeeAddressTO[] employeeAddressArr) {
		this.employeeAddressArr = employeeAddressArr;
	}

	public void setEmployeeAddressList(List<EmployeeAddressTO> employeeAddressList) {
		this.employeeAddressList = employeeAddressList;
	}

	public String getBarangay() {
		return barangay;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getNickname() {
		return nickname;
	}

	public String getCellNo() {
		return cellNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}

	public String getDivision() {
		return division;
	}

	public String getPosition() {
		return position;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "UpdateRequest [firstName=" + firstName + ", lastName=" + lastName + ", suffix=" + suffix
				+ ", middleName=" + middleName + ", nickname=" + nickname + ", cellNo=" + cellNo + ", telNo=" + telNo
				+ ", emailAddress=" + emailAddress + ", gender=" + gender + ", birthdate=" + birthdate
				+ ", maritalStatus=" + maritalStatus + ", hiringDate=" + hiringDate + ", division=" + division
				+ ", position=" + position + ", employeeAddressArr=" + Arrays.toString(employeeAddressArr)
				+ ", employeeAddressList=" + employeeAddressList + ", street=" + street + ", barangay=" + barangay
				+ ", city=" + city + ", province=" + province + "]";
	}
	
	
}
