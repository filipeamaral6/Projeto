package com.polarising.bootsecurity.security;


import java.io.IOException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.polarising.bootsecurity.db.UserRepository;
import com.polarising.bootsecurity.model.User;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	
	public UserPrincipalDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(s);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		
		return userPrincipal;
	}
	
	private List<User> fetchUsers() throws IOException {
		String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
				+ "   <soapenv:Header/>\n" + "   <soapenv:Body/>\n" + "</soapenv:Envelope>";
		try {
			List<User> users = xmlParserService.getUsersFromXML(http.post(url, "/users", requestBody, getUsersUrl));
			return users;
		} catch (Exception e) {
			throw new ApiRequestException("Unable to reach server");
		}

	}

}
