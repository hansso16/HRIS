package com.soses.hris.auth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.soses.hris.entity.Role;
import com.soses.hris.entity.User;

public class UserDetailsImp implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7137660071839033186L;
	private String username;
	private String password;
	private boolean isEnabled;
	private LocalDate terminationDate;
	private List<Role> roles;

	public UserDetailsImp() { }
	
	public UserDetailsImp(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.terminationDate = user.getTerminationDate();
		if(terminationDate != null && terminationDate.isAfter(java.time.LocalDate.now())) {
			this.isEnabled = false;
		} else { 
			this.isEnabled = true;
		}
		this.roles = user.getRoles();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<>();
    	if (roles != null && !roles.isEmpty()) {
            for (Role role: roles) {
            	authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleCode()));
            }
        }
        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}
	
	public LocalDate getTerminationDate() {
		return terminationDate;
	}

}
