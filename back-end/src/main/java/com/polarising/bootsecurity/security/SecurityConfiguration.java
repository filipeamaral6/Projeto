package com.polarising.bootsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.polarising.bootsecurity.db.UserRepository;
import com.polarising.bootsecurity.jwt.JwtAuthenticationFilter;
import com.polarising.bootsecurity.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserPrincipalDetailsService userPrincipalDetailsService;
	private UserRepository userRepository;

	
	public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
		this.userRepository = userRepository;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth
			.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/user").hasAnyRole("ADMIN","USER")
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/users").hasRole("ADMIN");
	        
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
		
		return daoAuthenticationProvider;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
