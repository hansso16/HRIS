// Generated with g9.

package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The Class EmployeeDependent.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Entity(name="employee_dependent")
public class EmployeeDependent implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6015337559147095795L;

    /** Primary key. */
    protected static final String PK = "EmployeeDependentPrimary";

    /** The id. */
    @EmbeddedId
    private EmployeeDependentPK id;
    
    /** The dependent name. */
    @Column(name="DEPENDENT_NAME", length=50)
    private String dependentName;
    
    /** The dependent birthdate. */
    @Column(name="DEPENDENT_BIRTHDATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dependentBirthdate;
    
    /** The gender. */
    @Column(name="GENDER", length=1)
    private String gender;

    /** Default constructor. */
    public EmployeeDependent() {
        super();
    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public EmployeeDependentPK getId() {
		return id;
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(EmployeeDependentPK id) {
		this.id = id;
	}


	/**
     * Access method for dependentName.
     *
     * @return the current value of dependentName
     */
    public String getDependentName() {
        return dependentName;
    }

    /**
     * Setter method for dependentName.
     *
     * @param aDependentName the new value for dependentName
     */
    public void setDependentName(String aDependentName) {
        dependentName = aDependentName;
    }

    /**
     * Access method for dependentBirthdate.
     *
     * @return the current value of dependentBirthdate
     */
    public LocalDate getDependentBirthdate() {
        return dependentBirthdate;
    }

    /**
     * Setter method for dependentBirthdate.
     *
     * @param aDependentBirthdate the new value for dependentBirthdate
     */
    public void setDependentBirthdate(LocalDate aDependentBirthdate) {
        dependentBirthdate = aDependentBirthdate;
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


	@Override
	public String toString() {
		return "EmployeeDependent [id=" + id + ", dependentName=" + dependentName + ", dependentBirthdate="
				+ dependentBirthdate + ", gender=" + gender + ", toString()=" + super.toString() + "]";
	}
    
    
}
