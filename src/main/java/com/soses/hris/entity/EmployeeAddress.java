// Generated with g9.

package com.soses.hris.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="employee_address")
public class EmployeeAddress implements Serializable {

	private static final long serialVersionUID = -2089655412794287645L;

    protected static final String PK = "EmployeeAddressPrimary";


    @EmbeddedId
    private EmployeeAddressPK id;
    
    @Column(name="STREET", length=100)
    private String street;
    @Column(name="BARANGAY", length=50)
    private String barangay;
    @Column(name="CITY", length=50)
    private String city;
    @Column(name="PROVINCE", length=50)
    private String province;

    /** Default constructor. */
    public EmployeeAddress() {
        super();
    }

	public EmployeeAddressPK getId() {
		return id;
	}

	public void setId(EmployeeAddressPK id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "EmployeeAddress [id=" + id + ", street=" + street + ", barangay=" + barangay + ", city=" + city
				+ ", province=" + province + "]";
	}

    

}
