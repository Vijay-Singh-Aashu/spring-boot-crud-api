//package com.excellence.springbootcrudapisecurity.service;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class CustomUserDetails implements UserDetails {
//
//	private String username;
//	private String email;
//	private String password;
//	private Collection<? extends GrantedAuthority> authorities;
//	private String role;
//
//	public CustomUserDetails(String username, String email, String password,
//			Collection<? extends GrantedAuthority> authorities, String role) {
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.authorities = authorities;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//	
//	public String getRole() {
//		return email;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
