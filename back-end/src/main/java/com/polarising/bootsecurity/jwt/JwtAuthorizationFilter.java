package com.polarising.bootsecurity.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.polarising.bootsecurity.security.UserPrincipalDetailsService;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

//	private UserRepository userRepository;

	private UserPrincipalDetailsService userPrincipalDetailsService;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserPrincipalDetailsService userPrincipalDetailsService) {
		super(authenticationManager);
		this.userPrincipalDetailsService = userPrincipalDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Read the Authorization header, where the JWT token should be
		String header = request.getHeader(JwtProperties.HEADER_STRING);

		// If header does not contain BEARER or is null delegate to Spring impl and exit
		if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}

		// If header is present, try grab user principal from database and perform
		// authorization
		Authentication authentication = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Continue filter execution
		chain.doFilter(request, response);
	}

	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		try {
			String token = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");

			if (token != null) {
				// parse the token and validate it
				String username = JWT.require(HMAC512(JwtProperties.SECRET.getBytes())).build().verify(token)
						.getSubject();

				// If so, then grab user details and create spring auth token using username,
				// pass, authorities/roles
				if (username != null) {
					UserDetails userDetails = userPrincipalDetailsService.loadUserByUsername(username);
					// UserPrincipal principal = new UserPrincipal(user);
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
							userDetails.getAuthorities());
					return auth;
				}
				return null;
			}
			return null;
		} catch (Exception e) {
			throw (e);
		}
	}
}
