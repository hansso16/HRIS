package com.soses.hris.api;

import org.springframework.data.domain.Page;

import com.soses.hris.entity.ActivityHistory;

/**
 * The Class EmployeeActivityResponse.
 *
 * @author hso
 * @since Mar 15, 2022
 */
public class EmployeeActivityResponse extends BaseEmployeeResponse {

	/** The activity history list. */
	Page<ActivityHistory> activityHistoryPage;

	/**
	 * Gets the activity history page.
	 *
	 * @return the activity history page
	 */
	public Page<ActivityHistory> getActivityHistoryPage() {
		return activityHistoryPage;
	}


	/**
	 * Sets the activity history page.
	 *
	 * @param activityHistoryPage the new activity history page
	 */
	public void setActivityHistoryPage(Page<ActivityHistory> activityHistoryPage) {
		this.activityHistoryPage = activityHistoryPage;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeActivityResponse [activityHistoryPage=" + activityHistoryPage + ", toString()="
				+ super.toString() + "]";
	}
}
