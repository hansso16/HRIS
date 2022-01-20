package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * The Class ConfigParameter.
 *
 * @author hso
 * @since 15 Nov 2021
 */
@Entity(name="CONFIG_PARAM")
public class ConfigParam implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3156963419820843292L;

	/** The id. */
	@EmbeddedId
	private ConfigParamPK id;
	
	/** The description. */
	@Column(name="DESCRIPTION", length=100)
	private String description;
	
	/** The eff date. */
	@Column(name="EFF_DATE")
	private LocalDate effDate;
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ConfigParamPK id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ConfigParamPK getId() {
		return id;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the eff date.
	 *
	 * @return the eff date
	 */
	public LocalDate getEffDate() {
		return effDate;
	}
	
	/**
	 * Sets the eff date.
	 *
	 * @param effDate the new eff date
	 */
	public void setEffDate(LocalDate effDate) {
		this.effDate = effDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ConfigParam [id=" + id + ", description=" + description + ", effDate=" + effDate + "]";
	}
	
}
