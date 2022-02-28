package com.soses.hris.dto;

import com.soses.hris.entity.Barangay;
import com.soses.hris.entity.Municipal;
import com.soses.hris.entity.Province;
import com.soses.hris.entity.Region;

/**
 * The Class EmployeeAddressHistoryTO.
 *
 * @author hso
 * @since Feb 28, 2022
 */
public class EmployeeAddressHistoryTO extends BaseEmployeeTO {

	/** The address type. */
	private String addressType;
	
	/** The address type name. */
	private String addressTypeName;
	
	/** The street. */
	private String street;
	
	/** The barangay. */
	private Barangay barangay;
	
	/** The city. */
	private Municipal municipal;
	
	/** The province. */
	private Province province;
	
	/** The region. */
	private Region region;
	
	/** The zip code. */
	private String zipCode;

	/**
	 * Gets the address type.
	 *
	 * @return the address type
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * Gets the address type name.
	 *
	 * @return the address type name
	 */
	public String getAddressTypeName() {
		return addressTypeName;
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
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the address type.
	 *
	 * @param addressType the new address type
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * Sets the address type name.
	 *
	 * @param addressTypeName the new address type name
	 */
	public void setAddressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
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
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressHistoryTO [addressType=" + addressType + ", addressTypeName=" + addressTypeName
				+ ", street=" + street + ", barangay=" + barangay + ", municipal=" + municipal + ", province="
				+ province + ", region=" + region + ", zipCode=" + zipCode + "]";
	}
	
	
}
