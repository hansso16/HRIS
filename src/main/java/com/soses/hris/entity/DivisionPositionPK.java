package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class DivisionPositionPK.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Embeddable
public class DivisionPositionPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6700249264793275958L;

	/** The employee id. */
	@Column(name="DIVISION_CODE")
	private String divisionCode;
	
	/** The role id. */
	@Column(name="POSITION_CODE")
	private String positionCode;

	/**
	 * Gets the division code.
	 *
	 * @return the division code
	 */
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	 * Gets the position code.
	 *
	 * @return the position code
	 */
	public String getPositionCode() {
		return positionCode;
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
	 * Sets the position code.
	 *
	 * @param positionCode the new position code
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DivisionPositionPK [divisionCode=" + divisionCode + ", positionCode=" + positionCode + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(divisionCode, positionCode);
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
		DivisionPositionPK other = (DivisionPositionPK) obj;
		return Objects.equals(divisionCode, other.divisionCode) && Objects.equals(positionCode, other.positionCode);
	}
}
