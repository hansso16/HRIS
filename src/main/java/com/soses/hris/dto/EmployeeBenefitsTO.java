package com.soses.hris.dto;

import java.time.LocalDate;

/**
 * The Class EmployeeBenefits.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeBenefitsTO extends BaseEmployeeTO {

	/** The sss no. */
	private String sssNo;
	
	/** The sss membership date. */
	private LocalDate sssMembershipDate;
	
	/** The phil health no. */
	private String philHealthNo;
	
	/** The phil health membership date. */
	private LocalDate philHealthMembershipDate;
	
	/** The pagibig no. */
	private String pagibigNo;
	
	/** The pagibig membership date. */
	private LocalDate pagibigMembershipDate;
	
	/** The tin no. */
	private String tinNo;
	
	/**
	 * Gets the sss no.
	 *
	 * @return the sss no
	 */
	public String getSssNo() {
		return sssNo;
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
	 * Gets the sss membership date.
	 *
	 * @return the sss membership date
	 */
	public LocalDate getSssMembershipDate() {
		return sssMembershipDate;
	}
	
	/**
	 * Sets the sss membership date.
	 *
	 * @param sssMembershipDate the new sss membership date
	 */
	public void setSssMembershipDate(LocalDate sssMembershipDate) {
		this.sssMembershipDate = sssMembershipDate;
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
	 * Sets the phil health no.
	 *
	 * @param philHealthNo the new phil health no
	 */
	public void setPhilHealthNo(String philHealthNo) {
		this.philHealthNo = philHealthNo;
	}
	
	/**
	 * Gets the phil health membership date.
	 *
	 * @return the phil health membership date
	 */
	public LocalDate getPhilHealthMembershipDate() {
		return philHealthMembershipDate;
	}
	
	/**
	 * Sets the phil health membership date.
	 *
	 * @param philHealthMembershipDate the new phil health membership date
	 */
	public void setPhilHealthMembershipDate(LocalDate philHealthMembershipDate) {
		this.philHealthMembershipDate = philHealthMembershipDate;
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
	 * Sets the pagibig no.
	 *
	 * @param pagibigNo the new pagibig no
	 */
	public void setPagibigNo(String pagibigNo) {
		this.pagibigNo = pagibigNo;
	}
	
	/**
	 * Gets the pagibig membership date.
	 *
	 * @return the pagibig membership date
	 */
	public LocalDate getPagibigMembershipDate() {
		return pagibigMembershipDate;
	}
	
	/**
	 * Sets the pagibig membership date.
	 *
	 * @param pagibigMembershipDate the new pagibig membership date
	 */
	public void setPagibigMembershipDate(LocalDate pagibigMembershipDate) {
		this.pagibigMembershipDate = pagibigMembershipDate;
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
		return "EmployeeBenefits [sssNo=" + sssNo + ", sssMembershipDate=" + sssMembershipDate + ", philHealthNo="
				+ philHealthNo + ", philHealthMembershipDate=" + philHealthMembershipDate + ", pagibigNo=" + pagibigNo
				+ ", pagibigMembershipDate=" + pagibigMembershipDate + ", tinNo=" + tinNo + "]";
	}
	
}
