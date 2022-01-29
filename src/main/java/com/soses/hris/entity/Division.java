package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * The Class Division.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Entity(name="CFG_DIVISION")
public class Division implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4302305890183446131L;

	/** The id. */
	@EmbeddedId
	private DivisionPK id;
    
    /** The last name. */
    @Column(name="DIVISION_SHORT_NAME", length=10)
    private String divisionShortName;
    
    /** The first name. */
    @Column(name="DIVISION_NAME", length=50)
    private String divisionName;

    /** The last name. */
    @Column(name="DIVISION_SHORT_DESC", length=10)
    private String divisionShortDesc;
    
    /** The first name. */
    @Column(name="DIVISION_DESCRIPTION", length=50)
    private String divisionDescription;
    
    /** The suffix. */
    @Column(name="EFF_DATE")
    private LocalDate effDate;
    
    /** The company code. */
    @Column(name="COMPANY_CODE")
    private String companyCode;
    
    /** The position list. */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "CFG_DIVISION_POSITION",
    		joinColumns = @JoinColumn(
    				name = "DIVISION_CODE", referencedColumnName = "DIVISION_CODE"),
    		inverseJoinColumns = @JoinColumn(
    				name = "POSITION_CODE", referencedColumnName = "POSITION_CODE")
    		)
    private List<Position> positionList;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public DivisionPK getId() {
		return id;
	}

	/**
	 * Gets the division short name.
	 *
	 * @return the division short name
	 */
	public String getDivisionShortName() {
		return divisionShortName;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Gets the division short desc.
	 *
	 * @return the division short desc
	 */
	public String getDivisionShortDesc() {
		return divisionShortDesc;
	}

	/**
	 * Gets the division description.
	 *
	 * @return the division description
	 */
	public String getDivisionDescription() {
		return divisionDescription;
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
	 * Gets the company code.
	 *
	 * @return the company code
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * Gets the position list.
	 *
	 * @return the position list
	 */
	public List<Position> getPositionList() {
		return positionList;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(DivisionPK id) {
		this.id = id;
	}

	/**
	 * Sets the division short name.
	 *
	 * @param divisionShortName the new division short name
	 */
	public void setDivisionShortName(String divisionShortName) {
		this.divisionShortName = divisionShortName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the new division name
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Sets the division short desc.
	 *
	 * @param divisionShortDesc the new division short desc
	 */
	public void setDivisionShortDesc(String divisionShortDesc) {
		this.divisionShortDesc = divisionShortDesc;
	}

	/**
	 * Sets the division description.
	 *
	 * @param divisionDescription the new division description
	 */
	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
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
	 * Sets the company code.
	 *
	 * @param companyCode the new company code
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * Sets the position list.
	 *
	 * @param positionList the new position list
	 */
	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Division [id=" + id + ", divisionShortName=" + divisionShortName + ", divisionName=" + divisionName
				+ ", divisionShortDesc=" + divisionShortDesc + ", divisionDescription=" + divisionDescription
				+ ", effDate=" + effDate + ", companyCode=" + companyCode + ", positionList=" + positionList + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(companyCode, divisionDescription, divisionName, divisionShortDesc, divisionShortName,
				effDate, id, positionList);
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
		Division other = (Division) obj;
		return Objects.equals(companyCode, other.companyCode)
				&& Objects.equals(divisionDescription, other.divisionDescription)
				&& Objects.equals(divisionName, other.divisionName)
				&& Objects.equals(divisionShortDesc, other.divisionShortDesc)
				&& Objects.equals(divisionShortName, other.divisionShortName) && Objects.equals(effDate, other.effDate)
				&& Objects.equals(id, other.id) && Objects.equals(positionList, other.positionList);
	}
}
