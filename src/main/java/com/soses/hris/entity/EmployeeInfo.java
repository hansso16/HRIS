package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class EmployeeInfo.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Entity(name="employee_info")
public class EmployeeInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2609822094620829284L;

	/** Primary key. */
    protected static final String PK = "employeeId";

    /** The employee id. */
    @Id
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10)
    private int employeeId;
    
    /** The emergency name. */
    @Column(name="EMERGENCY_NAME", length=50)
    private String emergencyName;
    
    /** The emergency address. */
    @Column(name="EMERGENCY_ADDRESS", length=50)
    private String emergencyAddress;
    
    /** The emergency contact. */
    @Column(name="EMERGENCY_CONTACT", length=11)
    private String emergencyContact;
    
    /** The mother name. */
    @Column(name="MOTHER_NAME", length=50)
    private String motherName;
    
    /** The mother birthdate. */
    @Column(name="MOTHER_BIRTHDATE")
    private LocalDate motherBirthdate;
    
    /** The father name. */
    @Column(name="FATHER_NAME", length=50)
    private String fatherName;
    
    /** The father birthdate. */
    @Column(name="FATHER_BIRTHDATE")
    private LocalDate fatherBirthdate;

    /** Default constructor. */
    public EmployeeInfo() {
        super();
    }

    /**
     * Access method for employeeId.
     *
     * @return the current value of employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Setter method for employeeId.
     *
     * @param aEmployeeId the new value for employeeId
     */
    public void setEmployeeId(int aEmployeeId) {
        employeeId = aEmployeeId;
    }

    /**
     * Access method for emergencyName.
     *
     * @return the current value of emergencyName
     */
    public String getEmergencyName() {
        return emergencyName;
    }

    /**
     * Setter method for emergencyName.
     *
     * @param aEmergencyName the new value for emergencyName
     */
    public void setEmergencyName(String aEmergencyName) {
        emergencyName = aEmergencyName;
    }

    /**
     * Access method for emergencyAddress.
     *
     * @return the current value of emergencyAddress
     */
    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    /**
     * Setter method for emergencyAddress.
     *
     * @param aEmergencyAddress the new value for emergencyAddress
     */
    public void setEmergencyAddress(String aEmergencyAddress) {
        emergencyAddress = aEmergencyAddress;
    }

    /**
     * Access method for emergencyContact.
     *
     * @return the current value of emergencyContact
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * Setter method for emergencyContact.
     *
     * @param aEmergencyContact the new value for emergencyContact
     */
    public void setEmergencyContact(String aEmergencyContact) {
        emergencyContact = aEmergencyContact;
    }

    /**
     * Access method for motherName.
     *
     * @return the current value of motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * Setter method for motherName.
     *
     * @param aMotherName the new value for motherName
     */
    public void setMotherName(String aMotherName) {
        motherName = aMotherName;
    }

    /**
     * Access method for motherBirthdate.
     *
     * @return the current value of motherBirthdate
     */
    public LocalDate getMotherBirthdate() {
        return motherBirthdate;
    }

    /**
     * Setter method for motherBirthdate.
     *
     * @param aMotherBirthdate the new value for motherBirthdate
     */
    public void setMotherBirthdate(LocalDate aMotherBirthdate) {
        motherBirthdate = aMotherBirthdate;
    }

    /**
     * Access method for fatherName.
     *
     * @return the current value of fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Setter method for fatherName.
     *
     * @param aFatherName the new value for fatherName
     */
    public void setFatherName(String aFatherName) {
        fatherName = aFatherName;
    }

    /**
     * Access method for fatherBirthdate.
     *
     * @return the current value of fatherBirthdate
     */
    public LocalDate getFatherBirthdate() {
        return fatherBirthdate;
    }

    /**
     * Setter method for fatherBirthdate.
     *
     * @param aFatherBirthdate the new value for fatherBirthdate
     */
    public void setFatherBirthdate(LocalDate aFatherBirthdate) {
        fatherBirthdate = aFatherBirthdate;
    }

    /**
     * Compares the key for this instance with another EmployeeInfo.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class EmployeeInfo and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EmployeeInfo)) {
            return false;
        }
        EmployeeInfo that = (EmployeeInfo) other;
        if (this.getEmployeeId() != that.getEmployeeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another EmployeeInfo.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EmployeeInfo)) return false;
        return this.equalKeys(other) && ((EmployeeInfo)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getEmployeeId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[EmployeeInfo |");
        sb.append(" employeeId=").append(getEmployeeId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("employeeId", Integer.valueOf(getEmployeeId()));
        return ret;
    }

}
