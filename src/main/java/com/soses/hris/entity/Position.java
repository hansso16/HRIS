package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * The Class Position.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Entity(name="cfg_position")
public class Position implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4480557740833129682L;

	/** The company code. */
	@EmbeddedId
    private PositionPK id;
    
    /** The last name. */
    @Column(name="POSITION_SHORT_NAME", length=10)
    private String positionShortName;
    
    /** The first name. */
    @Column(name="POSITION_NAME", length=50)
    private String positionName;

    /** The suffix. */
    @Column(name="EFF_DATE")
    private LocalDate effDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public PositionPK getId() {
		return id;
	}

	/**
	 * Gets the position short name.
	 *
	 * @return the position short name
	 */
	public String getPositionShortName() {
		return positionShortName;
	}

	/**
	 * Gets the position name.
	 *
	 * @return the position name
	 */
	public String getPositionName() {
		return positionName;
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(PositionPK id) {
		this.id = id;
	}

	/**
	 * Sets the position short name.
	 *
	 * @param positionShortName the new position short name
	 */
	public void setPositionShortName(String positionShortName) {
		this.positionShortName = positionShortName;
	}

	/**
	 * Sets the position name.
	 *
	 * @param positionName the new position name
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the new eff date
	 */
	public void setEffDate(LocalDate effDate) {
		this.effDate = effDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(effDate, id, positionName, positionShortName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return Objects.equals(effDate, other.effDate) && Objects.equals(id, other.id)
				&& Objects.equals(positionName, other.positionName)
				&& Objects.equals(positionShortName, other.positionShortName);
	}
}
