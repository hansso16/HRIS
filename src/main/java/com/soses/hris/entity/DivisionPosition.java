package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * The Class DivisionPosition.
 *
 * @author hso
 * @since Jan 26, 2022
 */
@Entity(name="cfg_division_position")
public class DivisionPosition implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1360414272822462683L;

	/** The id. */
	@EmbeddedId
    private DivisionPositionPK id;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public DivisionPositionPK getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(DivisionPositionPK id) {
		this.id = id;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DivisionPosition [id=" + id + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		DivisionPosition other = (DivisionPosition) obj;
		return Objects.equals(id, other.id);
	}
}
