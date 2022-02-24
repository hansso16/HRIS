package com.soses.hris.dto;

import java.util.List;

import com.soses.hris.entity.Barangay;
import com.soses.hris.entity.Municipal;
import com.soses.hris.entity.Province;
import com.soses.hris.entity.Region;

/**
 * The Class EmployeeAddressDTO.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeAddressTO extends BaseEmployeeTO {

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
	
	/** The region list. */
	private List<Region> regionList;
	
	/** The province list. */
	private List<Province> provinceList;
	
	/** The municipal list. */
	private List<Municipal> municipalList;
	
	/** The barangay list. */
	private List<Barangay> barangayList;
	
	/** The zip code. */
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
	 * Gets the region list.
	 *
	 * @return the region list
	 */
	public List<Region> getRegionList() {
		return regionList;
	}

	/**
	 * Gets the province list.
	 *
	 * @return the province list
	 */
	public List<Province> getProvinceList() {
		return provinceList;
	}

	/**
	 * Gets the municipal list.
	 *
	 * @return the municipal list
	 */
	public List<Municipal> getMunicipalList() {
		return municipalList;
	}

	/**
	 * Gets the barangay list.
	 *
	 * @return the barangay list
	 */
	public List<Barangay> getBarangayList() {
		return barangayList;
	}

	/**
	 * Sets the region list.
	 *
	 * @param regionList the new region list
	 */
	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	/**
	 * Sets the province list.
	 *
	 * @param provinceList the new province list
	 */
	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	/**
	 * Sets the municipal list.
	 *
	 * @param municipalList the new municipal list
	 */
	public void setMunicipalList(List<Municipal> municipalList) {
		this.municipalList = municipalList;
	}

	/**
	 * Sets the barangay list.
	 *
	 * @param barangayList the new barangay list
	 */
	public void setBarangayList(List<Barangay> barangayList) {
		this.barangayList = barangayList;
	}

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

	@Override
	public String toString() {
		return "EmployeeAddressTO [addressType=" + addressType + ", addressTypeName=" + addressTypeName + ", street="
				+ street + ", barangay=" + barangay + ", municipal=" + municipal + ", province=" + province
				+ ", region=" + region + ", regionList=" + regionList + ", provinceList=" + provinceList
				+ ", municipalList=" + municipalList + ", barangayList=" + barangayList + ", zipCode=" + zipCode + "]";
	}

	/**
	 * Instantiates a new employee address TO.
	 *
	 * @param addressType the address type
	 * @param addressTypeName the address type name
	 */
	public EmployeeAddressTO(String addressType, String addressTypeName) {
		super();
		this.addressType = addressType;
		this.addressTypeName = addressTypeName;
	}
	
	/**
	 * Instantiates a new employee address TO.
	 */
	public EmployeeAddressTO() { }
	
}
