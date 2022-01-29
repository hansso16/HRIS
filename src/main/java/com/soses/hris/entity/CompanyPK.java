package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class CompanyPK.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Embeddable
public class CompanyPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8617260503271174410L;

	/** The code. */
	@Column(name="COMPANY_CODE", unique=true, nullable=false, precision=3)
	private String companyCode;
	
	/** The end date. */
	@Column(name="END_DATE")
	private LocalDate endDate;

	/**
	 * Gets the company code.
	 *
	 * @return the company code
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the company code.
	 *
	 * @param companyCode the new company code
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CompanyPK [companyCode=" + companyCode + ", endDate=" + endDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(companyCode, endDate);
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
		CompanyPK other = (CompanyPK) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(endDate, other.endDate);
	}
}
