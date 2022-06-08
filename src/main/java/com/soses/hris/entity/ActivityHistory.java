package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class ActivityHistory.
 *
 * @author hso
 * @since Mar 10, 2022
 */
@Entity(name="activity_history")
public class ActivityHistory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 126662475514084388L;

	/** The activity id. */
    @Id
    @Column(name="ACTIVITY_ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int activityId;
	
	/** The employee id. */
    @Column(name="EMPLOYEE_ID")
	private String employeeId;
	
	/** The activity text. */
    @Column(name="ACTIVITY_TEXT")
	private String activityText;
	
	/** The username. */
    @Column(name="USERNAME")
	private String username;
	
	/** The entry timestamp. */
    @Column(name="ENTRY_TIMESTAMP")
	private LocalDateTime entryTimestamp;

	/**
	 * Gets the activity id.
	 *
	 * @return the activity id
	 */
	public int getActivityId() {
		return activityId;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Gets the activity text.
	 *
	 * @return the activity text
	 */
	public String getActivityText() {
		return activityText;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the entry timestamp.
	 *
	 * @return the entry timestamp
	 */
	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
	}

	/**
	 * Sets the activity id.
	 *
	 * @param activityId the new activity id
	 */
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Sets the activity text.
	 *
	 * @param activityText the new activity text
	 */
	public void setActivityText(String activityText) {
		this.activityText = activityText;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the entry timestamp.
	 *
	 * @param entryTimestamp the new entry timestamp
	 */
	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ActivityHistory [activityId=" + activityId + ", employeeId=" + employeeId + ", activityText="
				+ activityText + ", username=" + username + ", entryTimestamp=" + entryTimestamp + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activityId, activityText, employeeId, entryTimestamp, username);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityHistory other = (ActivityHistory) obj;
		return activityId == other.activityId && Objects.equals(activityText, other.activityText)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(entryTimestamp, other.entryTimestamp)
				&& Objects.equals(username, other.username);
	}
}
