// Generated with g9.

package com.soses.hris.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="user_role")
public class UserRole implements Serializable {


    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8669110306306217455L;

    @EmbeddedId
    private UserRolePK id;

    /** Default constructor. */
    public UserRole() {
        super();
    }

	public UserRolePK getId() {
		return id;
	}

	public void setId(UserRolePK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + "]";
	}

}
