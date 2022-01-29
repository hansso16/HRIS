package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class PositionPK.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Embeddable
public class PositionPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8811266754948386931L;

	/** The code. */
	@Column(name="POSITION_CODE", unique=true, nullable=false, precision=2)
	private String positionCode;
	
	/** The end date. */
	@Column(name="END_DATE")
	private LocalDate endDate;

	/**
	 * Gets the position code.
	 *
	 * @return the position code
	 */
	public String getPositionCode() {
		return positionCode;
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
	 * Sets the position code.
	 *
	 * @param positionCode the new position code
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
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
		return "PositionPK [positionCode=" + positionCode + ", endDate=" + endDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(endDate, positionCode);
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
		PositionPK other = (PositionPK) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(positionCode, other.positionCode);
	}
}
