package com.soses.hris.dto;

import java.time.LocalDate;
import java.util.List;

import com.soses.hris.entity.Company;
import com.soses.hris.entity.Division;
import com.soses.hris.entity.Position;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDTO.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeTO extends BaseEmployeeTO {

	/** The last name. */
	private String lastName;
	
	/** The first name. */
	private String firstName;
	
	/** The suffix. */
	private String suffix;
	
	/** The middle name. */
	private String middleName;
	
	/** The nickname. */
	private String nickname;
	
	/** The cell no. */
	private String cellNo;
	
	/** The tele no. */
	private String teleNo;
	
	/** The email address. */
	private String emailAddress;
	
	/** The gender. */
	private String gender;
	
	/** The birthdate. */
	private LocalDate birthdate;
	
	/** The marital status. */
	private String maritalStatus;
	
	/** The hiring date. */
	private LocalDate hiringDate;
	
	/** The termination date. */
	private LocalDate terminationDate;
	
	/** The regularization date. */
	private LocalDate regularizationDate;
	
	/** The company code. */
	private String companyCode;
	
	/** The division code. */
	private String divisionCode;
	
	/** The position code. */
	private String positionCode;
	
	/** The company list. */
	private List<Company> companyList;
	
	/** The division list. */
	private List<Division> divisionList;
	
	/** The position list. */
	private List<Position> positionList;
	
	/** The sss no. */
	private String sssNo;
	
	/** The phil health no. */
	private String philHealthNo;
	
	/** The pagibig no. */
	private String pagibigNo;
	
	/** The tin no. */
	private String tinNo;
	
	/** The photo. */
	private String photo;
	
	/** The emp photo base 64. */
	private String empPhotoBase64;

	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeTO [lastName=" + lastName + ", firstName=" + firstName + ", suffix=" + suffix + ", middleName="
				+ middleName + ", nickname=" + nickname + ", cellNo=" + cellNo + ", teleNo=" + teleNo
				+ ", emailAddress=" + emailAddress + ", gender=" + gender + ", birthdate=" + birthdate
				+ ", maritalStatus=" + maritalStatus + ", hiringDate=" + hiringDate + ", terminationDate="
				+ terminationDate + ", regularizationDate=" + regularizationDate + ", companyCode=" + companyCode
				+ ", divisionCode=" + divisionCode + ", positionCode=" + positionCode + ", companyList=" + companyList
				+ ", divisionList=" + divisionList + ", positionList=" + positionList + ", sssNo=" + sssNo
				+ ", philHealthNo=" + philHealthNo + ", pagibigNo=" + pagibigNo + ", tinNo=" + tinNo + ", photo="
				+ photo + ", empPhotoBase64=" + empPhotoBase64 + "]";
	}

	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo the new photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Gets the emp photo base 64.
	 *
	 * @return the emp photo base 64
	 */
	public String getEmpPhotoBase64() {
		return empPhotoBase64;
	}

	/**
	 * Sets the emp photo base 64.
	 *
	 * @param empPhotoBase64 the new emp photo base 64
	 */
	public void setEmpPhotoBase64(String empPhotoBase64) {
		this.empPhotoBase64 = empPhotoBase64;
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
	 * Gets the phil health no.
	 *
	 * @return the phil health no
	 */
	public String getPhilHealthNo() {
		return philHealthNo;
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
	 * Gets the tin no.
	 *
	 * @return the tin no
	 */
	public String getTinNo() {
		return tinNo;
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
	 * Sets the phil health no.
	 *
	 * @param philHealthNo the new phil health no
	 */
	public void setPhilHealthNo(String philHealthNo) {
		this.philHealthNo = philHealthNo;
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
	 * Sets the tin no.
	 *
	 * @param tinNo the new tin no
	 */
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
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
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
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
	 * Gets the suffix.
	 *
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
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
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
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
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
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
	 * Gets the cell no.
	 *
	 * @return the cell no
	 */
	public String getCellNo() {
		return cellNo;
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
	 * Gets the tele no.
	 *
	 * @return the tele no
	 */
	public String getTeleNo() {
		return teleNo;
	}
	
	/**
	 * Sets the tele no.
	 *
	 * @param teleNo the new tele no
	 */
	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
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
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	 * Gets the birthdate.
	 *
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
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
	 * Gets the marital status.
	 *
	 * @return the marital status
	 */
	public String getMaritalStatus() {
		return maritalStatus;
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
	 * Gets the hiring date.
	 *
	 * @return the hiring date
	 */
	public LocalDate getHiringDate() {
		return hiringDate;
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
	 * Gets the termination date.
	 *
	 * @return the termination date
	 */
	public LocalDate getTerminationDate() {
		return terminationDate;
	}
	
	/**
	 * Sets the termination date.
	 *
	 * @param terminationDate the new termination date
	 */
	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	/**
	 * Gets the regularization date.
	 *
	 * @return the regularization date
	 */
	public LocalDate getRegularizationDate() {
		return regularizationDate;
	}
	
	/**
	 * Sets the regularization date.
	 *
	 * @param regularizationDate the new regularization date
	 */
	public void setRegularizationDate(LocalDate regularizationDate) {
		this.regularizationDate = regularizationDate;
	}

	/**
	 * Gets the company list.
	 *
	 * @return the company list
	 */
	public List<Company> getCompanyList() {
		return companyList;
	}

	/**
	 * Gets the division list.
	 *
	 * @return the division list
	 */
	public List<Division> getDivisionList() {
		return divisionList;
	}

	/**
	 * Gets the position list.
	 *
	 * @return the position list
	 */
	public List<Position> getPositionList() {
		return positionList;
	}

	/**
	 * Sets the company list.
	 *
	 * @param companyList the new company list
	 */
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	/**
	 * Sets the division list.
	 *
	 * @param divisionList the new division list
	 */
	public void setDivisionList(List<Division> divisionList) {
		this.divisionList = divisionList;
	}

	/**
	 * Sets the position list.
	 *
	 * @param positionList the new position list
	 */
	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	/**
	 * Gets the company code.
	 *
	 * @return the company code
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * Gets the division code.
	 *
	 * @return the division code
	 */
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	 * Gets the position code.
	 *
	 * @return the position code
	 */
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * Sets the company code.
	 *
	 * @param companyCode the new company code
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * Sets the division code.
	 *
	 * @param divisionCode the new division code
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	/**
	 * Sets the position code.
	 *
	 * @param positionCode the new position code
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

}
