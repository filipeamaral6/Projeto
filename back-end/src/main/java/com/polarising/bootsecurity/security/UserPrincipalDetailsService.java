package com.polarising.bootsecurity.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.polarising.bootsecurity.exceptions.CustomExceptionMessage;
import com.polarising.bootsecurity.model.User;
import com.polarising.bootsecurity.soap.user.example.xmlns._1565108737830.UserService;
import com.polarising.bootsecurity.soap.user.tibco.schemas.user.InputUsers;
import com.polarising.bootsecurity.soap.user.tibco.schemas.user.Root;

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
					User user = new User(inputUser.getUsername(), inputUser.getPassword(), inputUser.getEmail(),
							inputUser.getRole());
					users.add(user);
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
		} catch (Exception e) {
			throw new CustomExceptionMessage("Invalid username/password combination");
		}
	}
}

	
