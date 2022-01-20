package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Barangay.
 *
 * @author hso
 * @since Jan 20, 2022
 */
@Entity(name="CFG_BARANGAY")
public class Barangay implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3774216360341751256L;

	/** The barangay id. */
	@Id
    @Column(name="BARANGAY_ID", unique=true, nullable=false)
    private String barangayId;
	
	/** The region name. */
	@Column(name="MUNICIPAL_ID")
	private String municipalId;
	
	/** The region description. */
	@Column(name="BARANGAY_NAME", length=100)
	private String barangayName;

	/**
	 * Gets the barangay id.
	 *
	 * @return the barangay id
	 */
	public String getBarangayId() {
		return barangayId;
	}

	/**
	 * Gets the municipal id.
	 *
	 * @return the municipal id
	 */
	public String getMunicipalId() {
		return municipalId;
	}

	/**
	 * Gets the barangay name.
	 *
	 * @return the barangay name
	 */
	public String getBarangayName() {
		return barangayName;
	}

	/**
	 * Sets the barangay id.
	 *
	 * @param barangayId the new barangay id
	 */
	public void setBarangayId(String barangayId) {
		this.barangayId = barangayId;
	}

	/**
	 * Sets the municipal id.
	 *
	 * @param municipalId the new municipal id
	 */
	public void setMunicipalId(String municipalId) {
		this.municipalId = municipalId;
	}

	/**
	 * Sets the barangay name.
	 *
	 * @param barangayName the new barangay name
	 */
	public void setBarangayName(String barangayName) {
		this.barangayName = barangayName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Barangay [barangayId=" + barangayId + ", municipalId=" + municipalId + ", barangayName=" + barangayName
				+ "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(barangayId, barangayName, municipalId);
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
		Barangay other = (Barangay) obj;
		return Objects.equals(barangayId, other.barangayId) && Objects.equals(barangayName, other.barangayName)
				&& Objects.equals(municipalId, other.municipalId);
	}
}
