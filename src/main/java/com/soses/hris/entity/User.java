package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Entity(name="user")
@Table(name="user")
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7970373912340336680L;

	/** Primary key. */
    protected static final String PK = "username";

//    @Column(name="EMPLOYEE_ID", precision=10)
//    private String employeeId;
    
    /** The username. */
    @Id
    @Column(name="USERNAME", unique=true, nullable=false, length=20)
    private String username;
    
    /** The password. */
    @Column(name="PASSWORD", length=68)
    private String password;
    
    /** The entry timestamp. */
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;
    
    /** The termination date. */
    @Column(name="TERMINATION_DATE")
    private LocalDate terminationDate;
    
    /** The employee. */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    /** The role. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    
    /** Default constructor. */
    public User() {
        super();
    }

    /**
     * Gets the employee.
     *
     * @return the employee
     */
    public Employee getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", entryTimestamp=" + entryTimestamp
				+ ", terminationDate=" + terminationDate + ", employee=" + employee + ", role=" + role + "]";
	}	
}
