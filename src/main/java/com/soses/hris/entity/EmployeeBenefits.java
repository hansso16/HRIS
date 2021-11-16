
package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class EmployeeBenefits.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Entity(name="employee_benefits")
public class EmployeeBenefits implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4292330981346989575L;

	/** Primary key. */
    protected static final String PK = "employeeId";

    /** The employee id. */
    @Id
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10)
    private int employeeId;
    
    /** The sss no. */
    @Column(name="SSS_NO", length=20)
    private String sssNo;
    
    /** The sss membership date. */
    @Column(name="SSS_MEMBERSHIP_DATE")
    private LocalDate sssMembershipDate;
    
    /** The philhealth no. */
    @Column(name="PHILHEALTH_NO", length=20)
    private String philhealthNo;
    
    /** The philhealth membership date. */
    @Column(name="PHILHEALTH_MEMBERSHIP_DATE")
    private LocalDate philhealthMembershipDate;
    
    /** The pagibig no. */
    @Column(name="PAGIBIG_NO", length=20)
    private String pagibigNo;
    
    /** The pagibig membership date. */
    @Column(name="PAGIBIG_MEMBERSHIP_DATE")
    private LocalDate pagibigMembershipDate;
    
    /** The tin no. */
    @Column(name="TIN_NO", length=20)
    private String tinNo;

    /** Default constructor. */
    public EmployeeBenefits() {
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
     * Access method for sssNo.
     *
     * @return the current value of sssNo
     */
    public String getSssNo() {
        return sssNo;
    }

    /**
     * Setter method for sssNo.
     *
     * @param aSssNo the new value for sssNo
     */
    public void setSssNo(String aSssNo) {
        sssNo = aSssNo;
    }

    /**
     * Access method for sssMembershipDate.
     *
     * @return the current value of sssMembershipDate
     */
    public LocalDate getSssMembershipDate() {
        return sssMembershipDate;
    }

    /**
     * Setter method for sssMembershipDate.
     *
     * @param aSssMembershipDate the new value for sssMembershipDate
     */
    public void setSssMembershipDate(LocalDate aSssMembershipDate) {
        sssMembershipDate = aSssMembershipDate;
    }

    /**
     * Access method for philhealthNo.
     *
     * @return the current value of philhealthNo
     */
    public String getPhilhealthNo() {
        return philhealthNo;
    }

    /**
     * Setter method for philhealthNo.
     *
     * @param aPhilhealthNo the new value for philhealthNo
     */
    public void setPhilhealthNo(String aPhilhealthNo) {
        philhealthNo = aPhilhealthNo;
    }

    /**
     * Access method for philhealthMembershipDate.
     *
     * @return the current value of philhealthMembershipDate
     */
    public LocalDate getPhilhealthMembershipDate() {
        return philhealthMembershipDate;
    }

    /**
     * Setter method for philhealthMembershipDate.
     *
     * @param aPhilhealthMembershipDate the new value for philhealthMembershipDate
     */
    public void setPhilhealthMembershipDate(LocalDate aPhilhealthMembershipDate) {
        philhealthMembershipDate = aPhilhealthMembershipDate;
    }

    /**
     * Access method for pagibigNo.
     *
     * @return the current value of pagibigNo
     */
    public String getPagibigNo() {
        return pagibigNo;
    }

    /**
     * Setter method for pagibigNo.
     *
     * @param aPagibigNo the new value for pagibigNo
     */
    public void setPagibigNo(String aPagibigNo) {
        pagibigNo = aPagibigNo;
    }

    /**
     * Access method for pagibigMembershipDate.
     *
     * @return the current value of pagibigMembershipDate
     */
    public LocalDate getPagibigMembershipDate() {
        return pagibigMembershipDate;
    }

    /**
     * Setter method for pagibigMembershipDate.
     *
     * @param aPagibigMembershipDate the new value for pagibigMembershipDate
     */
    public void setPagibigMembershipDate(LocalDate aPagibigMembershipDate) {
        pagibigMembershipDate = aPagibigMembershipDate;
    }

    /**
     * Access method for tinNo.
     *
     * @return the current value of tinNo
     */
    public String getTinNo() {
        return tinNo;
    }

    /**
     * Setter method for tinNo.
     *
     * @param aTinNo the new value for tinNo
     */
    public void setTinNo(String aTinNo) {
        tinNo = aTinNo;
    }

    /**
     * Compares the key for this instance with another EmployeeBenefits.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class EmployeeBenefits and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EmployeeBenefits)) {
            return false;
        }
        EmployeeBenefits that = (EmployeeBenefits) other;
        if (this.getEmployeeId() != that.getEmployeeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another EmployeeBenefits.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EmployeeBenefits)) return false;
        return this.equalKeys(other) && ((EmployeeBenefits)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[EmployeeBenefits |");
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
