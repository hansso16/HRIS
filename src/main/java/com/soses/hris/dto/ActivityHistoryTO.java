package com.soses.hris.dto;

import java.time.LocalDateTime;

public class ActivityHistoryTO {

	private int activityId;
	
	private String employeeId;
	
	private String activityText;
	
	private String username;
	
	private LocalDateTime entryTimestamp;

	public int getActivityId() {
		return activityId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getActivityText() {
		return activityText;
	}

	public String getUsername() {
		return username;
	}

	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setActivityText(String activityText) {
		this.activityText = activityText;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	@Override
	public String toString() {
		return "ActivityHistoryTO [activityId=" + activityId + ", employeeId=" + employeeId + ", activityText="
				+ activityText + ", username=" + username + "]";
	}
	
}
