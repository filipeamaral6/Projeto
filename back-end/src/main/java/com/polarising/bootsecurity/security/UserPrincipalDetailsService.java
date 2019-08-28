package com.polarising.bootsecurity.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.polarising.bootsecurity.exceptions.ApiError;
import com.polarising.bootsecurity.exceptions.CustomExceptionHandler;
import com.polarising.bootsecurity.exceptions.CustomExceptionMessage;
import com.polarising.bootsecurity.model.User;
import com.polarising.bootsecurity.soap.user.example.xmlns._1565108737830.UserService;
import com.polarising.bootsecurity.soap.user.tibco.schemas.user.InputUsers;
import com.polarising.bootsecurity.soap.user.tibco.schemas.user.Root;

@CrossOrigin(origins = "*")
@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	public UserPrincipalDetailsService() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {

			boolean foundUsername = false;
			
			UserPrincipal userPrincipalToReturn = new UserPrincipal();
			UserService userService = new UserService();
			Root getUsers = userService.getPortTypeGetAllUsersEndpoint1().operation();

			List<User> users = new ArrayList<User>();

			if (!getUsers.getInputUsers().isEmpty()) {
				for (InputUsers inputUser : getUsers.getInputUsers()) {
					if(inputUser.getStatus().equals("ACTIVE")) {
						User user = new User(Long.parseLong(inputUser.getId()), inputUser.getUsername(), inputUser.getPassword(), inputUser.getEmail(),
								inputUser.getRole());
						users.add(user);
					}
				}
			}

			for (User userPrincipal : users) {
				if (userPrincipal.getUsername().equals(username)) {
					userPrincipalToReturn = new UserPrincipal(userPrincipal);
					foundUsername = true;
					return userPrincipalToReturn;
				}  			
			}
			
			if(!foundUsername){
				throw new UsernameNotFoundException("Invalid username/password combination");
			}
			
			return userPrincipalToReturn;


		} catch (CustomExceptionMessage e) {
			throw new CustomExceptionMessage(e.getLocalizedMessage());
		} catch (BadCredentialsException e) {
			throw new CustomExceptionMessage(e.getLocalizedMessage());
		}
	}
}

	
