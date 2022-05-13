package com.soses.hris.api;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeProfileRequest.
 *
 * @author hso
 * @since Jan 3, 2022
 */
public class EmployeeProfileRequest extends BaseEmployeeRequest {

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
	
	/** The regularization date. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate regularizationDate;
	
	/** The termination date. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate terminationDate;
	
	/** The division. */
	private String division;
	
	/** The position. */
	private String position;
	
	/** The company. */
	private String company;
	
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
	 * Gets the regularization date.
	 *
	 * @return the regularization date
	 */
	public LocalDate getRegularizationDate() {
		return regularizationDate;
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
	 * Sets the regularization date.
	 *
	 * @param regularizationDate the new regularization date
	 */
	public void setRegularizationDate(LocalDate regularizationDate) {
		this.regularizationDate = regularizationDate;
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
	 * Gets the company.
	 *
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeProfileRequest [firstName=" + firstName + ", lastName=" + lastName + ", suffix=" + suffix
				+ ", middleName=" + middleName + ", nickname=" + nickname + ", cellNo=" + cellNo + ", telNo=" + telNo
				+ ", emailAddress=" + emailAddress + ", gender=" + gender + ", birthdate=" + birthdate
				+ ", maritalStatus=" + maritalStatus + ", hiringDate=" + hiringDate + ", regularizationDate="
				+ regularizationDate + ", terminationDate=" + terminationDate + ", division=" + division + ", position="
				+ position + ", company=" + company + ", sssNo=" + sssNo + ", philHealthNo=" + philHealthNo
				+ ", pagibigNo=" + pagibigNo + ", tinNo=" + tinNo + ", photo=" + photo + ", file=" + file + "]";
	}
}
