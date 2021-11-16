package com.soses.hris.api;

/**
 * The Class BaseEmployeeSearchResponse.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class BaseEmployeeSearchResponse extends BaseEmployeeResponse {

	/** The search type. */
	private String searchType;

	/**
	 * Gets the search type.
	 *
	 * @return the search type
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * Sets the search type.
	 *
	 * @param searchType the new search type
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeSearchResponse [searchType=" + searchType + "]";
	}

	
}
