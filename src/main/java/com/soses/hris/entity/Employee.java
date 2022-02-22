// Generated with g9.

package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The Class Employee.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Entity(name="employee")
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6098280335327550325L;

	/** Primary key. */
    protected static final String PK = "employeeId";


    /** The employee id. */
    @Id
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10)
    private String employeeId;
    
    /** The last name. */
    @Column(name="LAST_NAME", length=50)
    private String lastName;
    
    /** The first name. */
    @Column(name="FIRST_NAME", length=50)
    private String firstName;
    
    /** The suffix. */
    @Column(name="SUFFIX", length=10)
    private String suffix;
    
    /** The middle name. */
    @Column(name="MIDDLE_NAME", length=20)
    private String middleName;
    
    /** The nickname. */
    @Column(name="NICKNAME", length=20)
    private String nickname;
    
    /** The cell no. */
    @Column(name="CELL_NO", length=11)
    private String cellNo;
    
    /** The tel no. */
    @Column(name="TEL_NO", length=7)
    private String telNo;
    
    /** The email address. */
    @Column(name="EMAIL_ADDRESS", length=50)
    private String emailAddress;
    
    /** The gender. */
    @Column(name="GENDER", length=1)
    private String gender;
    
    /** The birthdate. */
    @Column(name="BIRTHDATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    
    /** The marital status. */
    @Column(name="MARITAL_STATUS", length=1)
    private String maritalStatus;
    
    /** The hiring date. */
    @Column(name="HIRING_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate hiringDate;
    
    /** The termination date. */
    @Column(name="TERMINATION_DATE")
    private LocalDate terminationDate;
    
    /** The regularization date. */
    @Column(name="REGULARIZATION_DATE")
    private LocalDate regularizationDate;
    
    /** The entry timestamp. */
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;
    
    /** The division. */
    @Column(name="DIVISION", length=3)
    private String division;
    
    /** The position. */
    @Column(name="POSITION", length=2)
    private String position;
    
    /** The company code. */
    @Column(name="COMPANY", length=3)
    private String company;
    
    /** The sss no. */
    @Column(name="SSS_NO", length=20)
    private String sssNo;
    
    /** The division. */
    @Column(name="PHIL_HEALTH_NO", length=20)
    private String philHealthNo;
    
    /** The position. */
    @Column(name="PAGIBIG_NO", length=20)
    private String pagibigNo;
    
    /** The company code. */
    @Column(name="TIN_NO", length=20)
    private String tinNo;
    
    /** Default constructor. */
    public Employee() {
        super();
    }

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId() {
		return employeeId;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
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
	 * Gets the termination date.
	 *
	 * @return the termination date
	 */
	public LocalDate getTerminationDate() {
		return terminationDate;
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
	 * Gets the entry timestamp.
	 *
	 * @return the entry timestamp
	 */
	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
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
	 * Gets the company.
	 *
	 * @return the company
	 */
	public String getCompany() {
		return company;
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
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * Sets the termination date.
	 *
	 * @param terminationDate the new termination date
	 */
	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
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
	 * Sets the entry timestamp.
	 *
	 * @param entryTimestamp the new entry timestamp
	 */
	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
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
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(String company) {
		this.company = company;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", suffix=" + suffix + ", middleName=" + middleName + ", nickname=" + nickname + ", cellNo=" + cellNo
				+ ", telNo=" + telNo + ", emailAddress=" + emailAddress + ", gender=" + gender + ", birthdate="
				+ birthdate + ", maritalStatus=" + maritalStatus + ", hiringDate=" + hiringDate + ", terminationDate="
				+ terminationDate + ", regularizationDate=" + regularizationDate + ", entryTimestamp=" + entryTimestamp
				+ ", division=" + division + ", position=" + position + ", company=" + company + ", sssNo=" + sssNo
				+ ", philHealthNo=" + philHealthNo + ", pagibigNo=" + pagibigNo + ", tinNo=" + tinNo + "]";
	}

}
