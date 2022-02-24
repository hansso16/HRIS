// Generated with g9.

package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class EmployeeAddress.
 *
 * @author hso
 * @since Jan 20, 2022
 */
@Entity(name="employee_address")
public class EmployeeAddress implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2089655412794287645L;

    /** The Constant PK. */
    protected static final String PK = "EmployeeAddressPrimary";


    /** The id. */
    @EmbeddedId
    private EmployeeAddressPK id;
    
    /** The street. */
    @Column(name="STREET", length=100)
    private String street;
    
    /** The barangay. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="barangay", referencedColumnName = "barangay_id")
    private Barangay barangay;
    
    /** The municipal. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="municipal", referencedColumnName = "municipal_id")
    private Municipal municipal;
    
    /** The province. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="province", referencedColumnName = "province_id")
    private Province province;
    
    /** The region. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="region", referencedColumnName = "region_id")
    private Region region;
    
    /** The zip code. */
    @Column(name="ZIP_CODE", length=10)
    private String zipCode;
    
	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public EmployeeAddressPK getId() {
		return id;
	}

	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Gets the barangay.
	 *
	 * @return the barangay
	 */
	public Barangay getBarangay() {
		return barangay;
	}

	/**
	 * Gets the municipal.
	 *
	 * @return the municipal
	 */
	public Municipal getMunicipal() {
		return municipal;
	}

	/**
	 * Gets the province.
	 *
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(EmployeeAddressPK id) {
		this.id = id;
	}

	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Sets the barangay.
	 *
	 * @param barangay the new barangay
	 */
	public void setBarangay(Barangay barangay) {
		this.barangay = barangay;
	}

	/**
	 * Sets the municipal.
	 *
	 * @param municipal the new municipal
	 */
	public void setMunicipal(Municipal municipal) {
		this.municipal = municipal;
	}

	/**
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddress [id=" + id + ", street=" + street + ", barangay=" + barangay + ", municipal="
				+ municipal + ", province=" + province + ", region=" + region + ", zipCode=" + zipCode + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(barangay, id, municipal, province, region, street);
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
		EmployeeAddress other = (EmployeeAddress) obj;
		return Objects.equals(barangay, other.barangay) && Objects.equals(id, other.id)
				&& Objects.equals(municipal, other.municipal) && Objects.equals(province, other.province)
				&& Objects.equals(region, other.region) && Objects.equals(street, other.street);
	}
}
