package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class DivisionPK.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Embeddable
public class DivisionPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5728540651687299158L;

	/** The code. */
	@Column(name="DIVISION_CODE", unique=true, nullable=false, precision=3)
	private String divisionCode;
	
	/** The end date. */
	@Column(name="END_DATE")
	private LocalDate endDate;

	/**
	 * Gets the division code.
	 *
	 * @return the division code
	 */
	public String getDivisionCode() {
		return divisionCode;
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
	 * Sets the division code.
	 *
	 * @param divisionCode the new division code
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
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
		return "DivisionPK [divisionCode=" + divisionCode + ", endDate=" + endDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(divisionCode, endDate);
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
		DivisionPK other = (DivisionPK) obj;
		return Objects.equals(divisionCode, other.divisionCode) && Objects.equals(endDate, other.endDate);
	}
}
