package com.soses.hris.api;

/**
 * The Class EmployeeImageRequest.
 *
 * @author hso
 * @since Mar 17, 2022
 */
public class EmployeeImageRequest extends BaseEmployeeRequest {

	/** The img name. */
	private String imgName;

	/**
	 * Gets the img name.
	 *
	 * @return the img name
	 */
	public String getImgName() {
		return imgName;
	}

	/**
	 * Sets the img name.
	 *
	 * @param imgName the new img name
	 */
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeImageRequest [imgName=" + imgName + ", toString()=" + super.toString() + "]";
	}
	
}
