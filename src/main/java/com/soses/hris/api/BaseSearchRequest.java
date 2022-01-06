package com.soses.hris.api;

/**
 * The Class BaseSearchRequest.
 *
 * @author hso
 * @since Jan 6, 2022
 */
public class BaseSearchRequest extends BaseEmployeeRequest {

	/** The size. */
	private String size;
	
	/** The page. */
	private String page;

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BaseSearchRequest [size=" + size + ", page=" + page + ", toString()=" + super.toString() + "]";
	}
}
