package com.soses.hris.api;

import com.soses.hris.dto.ErrorPageDTO;

/**
 * The Class BaseResponse.
 *
 * @author hso
 * @since 17 Nov 2021
 */
public class BaseResponse {

	/** The error. */
	private ErrorPageDTO error;

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public ErrorPageDTO getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(ErrorPageDTO error) {
		this.error = error;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BaseResponse [error=" + error + "]";
	}
	
}
