package com.polarising.bootsecurity.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.polarising.bootsecurity.model.User;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;

	public UserPrincipal(User user) {
		this.user = user;
	}

	public UserPrincipal() {
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.getActive() == 1;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//Extract list of roles
		String role = this.user.getRole();
		
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
		authorities.add(authority);

		return authorities;
	}
}
