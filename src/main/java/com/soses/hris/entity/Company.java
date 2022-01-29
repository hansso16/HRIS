package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * The Class Company.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Entity(name="CFG_COMPANY")
public class Company implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8938823552310888721L;

	/** The company code. */
	@EmbeddedId
	private CompanyPK id;
    
    /** The last name. */
    @Column(name="COMPANY_SHORT_NAME", length=10)
    private String companyShortName;
    
    /** The first name. */
    @Column(name="COMPANY_NAME", length=50)
    private String companyName;
    
    /** The suffix. */
    @Column(name="EFF_DATE")
    private LocalDate effDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public CompanyPK getId() {
		return id;
	}

	/**
	 * Gets the company short name.
	 *
	 * @return the company short name
	 */
	public String getCompanyShortName() {
		return companyShortName;
	}

	/**
	 * Gets the company name.
	 *
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Gets the eff date.
	 *
	 * @return the eff date
	 */
	public LocalDate getEffDate() {
		return effDate;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(CompanyPK id) {
		this.id = id;
	}

	/**
	 * Sets the company short name.
	 *
	 * @param companyShortName the new company short name
	 */
	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the new eff date
	 */
	public void setEffDate(LocalDate effDate) {
		this.effDate = effDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyShortName=" + companyShortName + ", companyName=" + companyName
				+ ", effDate=" + effDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(companyName, companyShortName, effDate, id);
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
		Company other = (Company) obj;
		return Objects.equals(companyName, other.companyName)
				&& Objects.equals(companyShortName, other.companyShortName) && Objects.equals(effDate, other.effDate)
				&& Objects.equals(id, other.id);
	}
}
