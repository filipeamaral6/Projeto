package com.polarising.bootsecurity.security;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polarising.bootsecurity.exceptions.CustomRestExceptionMessage;
import com.polarising.bootsecurity.model.User;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	public UserPrincipalDetailsService() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {

			return getUserPrincipal(username);

		} catch (CustomRestExceptionMessage e) {
			throw new CustomRestExceptionMessage(e.getLocalizedMessage());
		} catch (Exception e) {
			throw new CustomRestExceptionMessage("Invalid username/password combination");
		}
	}

	public UserPrincipal getUserPrincipal(String username) {

		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		try {
			ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8074/users-testing", String.class);
			List<User> users = mapper.readValue(response.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
		
			UserPrincipal userPrincipalToReturn = new UserPrincipal();
			
			for (User user : users) {
				System.out.println(user.getUsername());
				if (user.getUsername().equals(username)) {
					userPrincipalToReturn = new UserPrincipal(user);
				}
			}
			
			return userPrincipalToReturn;

		} catch (Exception e) {
			throw new CustomRestExceptionMessage("Failed to send REST request");
		}
	}
}