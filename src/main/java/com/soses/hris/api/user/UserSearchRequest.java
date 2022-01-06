package com.soses.hris.api.user;

/**
 * The Class UserSearchRequest.
 *
 * @author hso
 * @since Jan 6, 2022
 */
public class UserSearchRequest extends BaseUserRequest {

	/** The page number. */
	private String page;
	
	/** The size. */
	private String size;

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
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
	 * Gets the page.
	 *
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserSearchRequest [page=" + page + ", size=" + size + ", toString()=" + super.toString() + "]";
	}
	
}
