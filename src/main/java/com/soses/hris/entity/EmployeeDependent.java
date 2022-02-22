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

    /** The dependent relationship. */
    @Column(name="DEPENDENT_RELATIONSHIP", length=50)
    private String dependentRelationship;
    
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
	 * Gets the dependent name.
	 *
	 * @return the dependent name
	 */
	public String getDependentName() {
		return dependentName;
	}

	/**
	 * Gets the dependent relationship.
	 *
	 * @return the dependent relationship
	 */
	public String getDependentRelationship() {
		return dependentRelationship;
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
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
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
	 * Sets the dependent name.
	 *
	 * @param dependentName the new dependent name
	 */
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
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
		return "EmployeeDependent [id=" + id + ", dependentName=" + dependentName + ", dependentRelationship="
				+ dependentRelationship + ", dependentBirthdate=" + dependentBirthdate + ", gender=" + gender + "]";
	}
}
