
package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

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
    private String employeeId;
    
    /** The sss no. */
    @Column(name="SSS_NO", length=20)
    private String sssNo;
    
    /** The sss membership date. */
    @Column(name="SSS_MEMBERSHIP_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate sssMembershipDate;
    
    /** The philhealth no. */
    @Column(name="PHILHEALTH_NO", length=20)
    private String philhealthNo;
    
    /** The philhealth membership date. */
    @Column(name="PHILHEALTH_MEMBERSHIP_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate philhealthMembershipDate;
    
    /** The pagibig no. */
    @Column(name="PAGIBIG_NO", length=20)
    private String pagibigNo;
    
    /** The pagibig membership date. */
    @Column(name="PAGIBIG_MEMBERSHIP_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pagibigMembershipDate;
    
    /** The tin no. */
    @Column(name="TIN_NO", length=20)
    private String tinNo;

    /** Default constructor. */
    public EmployeeBenefits() {
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
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
     * Hash code.
     *
     * @return the int
     */
    @Override
	public int hashCode() {
		return Objects.hash(employeeId, pagibigMembershipDate, pagibigNo, philhealthMembershipDate, philhealthNo,
				sssMembershipDate, sssNo, tinNo);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBenefits other = (EmployeeBenefits) obj;
		return Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(pagibigMembershipDate, other.pagibigMembershipDate)
				&& Objects.equals(pagibigNo, other.pagibigNo)
				&& Objects.equals(philhealthMembershipDate, other.philhealthMembershipDate)
				&& Objects.equals(philhealthNo, other.philhealthNo)
				&& Objects.equals(sssMembershipDate, other.sssMembershipDate) && Objects.equals(sssNo, other.sssNo)
				&& Objects.equals(tinNo, other.tinNo);
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
