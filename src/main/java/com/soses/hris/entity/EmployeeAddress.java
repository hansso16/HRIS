// Generated with g9.

package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
    @Column(name="BARANGAY", length=50)
    private String barangay;
    
    /** The municipal. */
    @Column(name="MUNICIPAL", length=50)
    private String municipal;
    
    /** The province. */
    @Column(name="PROVINCE", length=50)
    private String province;
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddress [id=" + id + ", street=" + street + ", barangay=" + barangay + ", municipal="
				+ municipal + ", province=" + province + "]";
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
	public String getBarangay() {
		return barangay;
	}
	
	/**
	 * Gets the municipal.
	 *
	 * @return the municipal
	 */
	public String getMunicipal() {
		return municipal;
	}
	
	/**
	 * Gets the province.
	 *
	 * @return the province
	 */
	public String getProvince() {
		return province;
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
	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}
	
	/**
	 * Sets the municipal.
	 *
	 * @param municipal the new municipal
	 */
	public void setMunicipal(String municipal) {
		this.municipal = municipal;
	}
	
	/**
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(barangay, id, municipal, province, street);
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
				&& Objects.equals(street, other.street);
	}
}
