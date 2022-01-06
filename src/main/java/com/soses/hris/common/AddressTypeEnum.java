package com.soses.hris.common;

/**
 * The Enum AddressTypeEnum.
 *
 * @author hso
 * @since Jan 6, 2022
 */
public enum AddressTypeEnum {

	/** The present. */
	PRESENT("1", "Present Address"), /** The permanent. */
 PERMANENT("2", "Permanent Address"), /** The provincial. */
 PROVINCIAL("3", "Provincial Address");
	
	/** The address type. */
	private final String addressType;
	
	/** The address type name. */
	private final String addressTypeName;

	/**
	 * Instantiates a new address type enum.
	 *
	 * @param addressType the address type
	 * @param addressTypeName the address type name
	 */
	private AddressTypeEnum(String addressType, String addressTypeName) {
		this.addressType = addressType;
		this.addressTypeName = addressTypeName;
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
	 * Value of address type.
	 *
	 * @param addressType the address type
	 * @return the address type enum
	 */
	public static AddressTypeEnum valueOfAddressType(String addressType) {
	    for (AddressTypeEnum e : values()) {
	        if (e.addressType.equals(addressType)) {
	            return e;
	        }
	    }
	    return null;
	}
}
