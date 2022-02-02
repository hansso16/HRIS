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
    
    /** Default constructor. */
    public Employee() {
        super();
    }

    /**
     * Access method for employeeId.
     *
     * @return the current value of employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Setter method for employeeId.
     *
     * @param aEmployeeId the new value for employeeId
     */
    public void setEmployeeId(String aEmployeeId) {
        employeeId = aEmployeeId;
    }

    /**
     * Access method for lastName.
     *
     * @return the current value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName.
     *
     * @param aLastName the new value for lastName
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * Access method for firstName.
     *
     * @return the current value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for firstName.
     *
     * @param aFirstName the new value for firstName
     */
    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * Access method for suffix.
     *
     * @return the current value of suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Setter method for suffix.
     *
     * @param aSuffix the new value for suffix
     */
    public void setSuffix(String aSuffix) {
        suffix = aSuffix;
    }

    /**
     * Access method for middleName.
     *
     * @return the current value of middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Setter method for middleName.
     *
     * @param aMiddleName the new value for middleName
     */
    public void setMiddleName(String aMiddleName) {
        middleName = aMiddleName;
    }

    /**
     * Access method for nickname.
     *
     * @return the current value of nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Setter method for nickname.
     *
     * @param aNickname the new value for nickname
     */
    public void setNickname(String aNickname) {
        nickname = aNickname;
    }

    /**
     * Access method for cellNo.
     *
     * @return the current value of cellNo
     */
    public String getCellNo() {
        return cellNo;
    }

    /**
     * Setter method for cellNo.
     *
     * @param aCellNo the new value for cellNo
     */
    public void setCellNo(String aCellNo) {
        cellNo = aCellNo;
    }

    /**
     * Access method for telNo.
     *
     * @return the current value of telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * Setter method for telNo.
     *
     * @param aTelNo the new value for telNo
     */
    public void setTelNo(String aTelNo) {
        telNo = aTelNo;
    }

    /**
     * Access method for emailAddress.
     *
     * @return the current value of emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter method for emailAddress.
     *
     * @param aEmailAddress the new value for emailAddress
     */
    public void setEmailAddress(String aEmailAddress) {
        emailAddress = aEmailAddress;
    }

    /**
     * Access method for gender.
     *
     * @return the current value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setter method for gender.
     *
     * @param aGender the new value for gender
     */
    public void setGender(String aGender) {
        gender = aGender;
    }

    /**
     * Access method for birthdate.
     *
     * @return the current value of birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Setter method for birthdate.
     *
     * @param aBirthdate the new value for birthdate
     */
    public void setBirthdate(LocalDate aBirthdate) {
        birthdate = aBirthdate;
    }

    /**
     * Access method for maritalStatus.
     *
     * @return the current value of maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Setter method for maritalStatus.
     *
     * @param aMaritalStatus the new value for maritalStatus
     */
    public void setMaritalStatus(String aMaritalStatus) {
        maritalStatus = aMaritalStatus;
    }

    /**
     * Access method for hiringDate.
     *
     * @return the current value of hiringDate
     */
    public LocalDate getHiringDate() {
        return hiringDate;
    }

    /**
     * Setter method for hiringDate.
     *
     * @param aHiringDate the new value for hiringDate
     */
    public void setHiringDate(LocalDate aHiringDate) {
        hiringDate = aHiringDate;
    }

    /**
     * Access method for terminationDate.
     *
     * @return the current value of terminationDate
     */
    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    /**
     * Setter method for terminationDate.
     *
     * @param aTerminationDate the new value for terminationDate
     */
    public void setTerminationDate(LocalDate aTerminationDate) {
        terminationDate = aTerminationDate;
    }

    /**
     * Access method for regularizationDate.
     *
     * @return the current value of regularizationDate
     */
    public LocalDate getRegularizationDate() {
        return regularizationDate;
    }

    /**
     * Setter method for regularizationDate.
     *
     * @param aRegularizationDate the new value for regularizationDate
     */
    public void setRegularizationDate(LocalDate aRegularizationDate) {
        regularizationDate = aRegularizationDate;
    }

    /**
     * Access method for entryTimestamp.
     *
     * @return the current value of entryTimestamp
     */
    public LocalDateTime getEntryTimestamp() {
        return entryTimestamp;
    }

    /**
     * Setter method for entryTimestamp.
     *
     * @param aEntryTimestamp the new value for entryTimestamp
     */
    public void setEntryTimestamp(LocalDateTime aEntryTimestamp) {
        entryTimestamp = aEntryTimestamp;
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
				+ ", company=" + company + ", division=" + division + ", position=" + position + "]";
	}

}
