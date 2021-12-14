package com.soses.hris.dto;

/**
 * The Class EmployeeAddressDTO.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeAddressTO extends BaseEmployeeTO {

	/** The address type. */
	private String addressType;
	
	/** The street. */
	private String street;
	
	/** The barangay. */
	private String barangay;
	
	/** The city. */
	private String city;
	
	/** The province. */
	private String province;
	
	/**
	 * Gets the address type.
	 *
	 * @return the address type
	 */
	public String getAddressType() {
		return addressType;
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
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
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
	 * Gets the barangay.
	 *
	 * @return the barangay
	 */
	public String getBarangay() {
		return barangay;
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
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressDTO [addressType=" + addressType + ", street=" + street + ", barangay=" + barangay
				+ ", city=" + city + ", province=" + province + "]";
	}
	
}