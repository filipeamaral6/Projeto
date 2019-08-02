package com.polarising.bootsecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.model.User;
import com.polarising.bootsecurity.security.SecurityConfiguration;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

//	private UserRepository userRepository;
//
//	public UserController(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@Autowired
	SecurityConfiguration securityConfiguration;
	
    @GetMapping("admin")
    public String test1(){
        return "Admins only";
    }

    @GetMapping("user")
    public String test2(){
        return "Users only";
    }
    
//    @GetMapping("users")
//    public List<User> users() {
//    	return this.userRepository.findAll();
//    }
    
    @GetMapping("users-testing")
    public List<User> usersTesting() {
    	User user = new User("user", securityConfiguration.passwordEncoder().encode("user"), "USER" );
    	User admin = new User("admin", securityConfiguration.passwordEncoder().encode("admin"), "ADMIN" );
    	List<User> users = Arrays.asList(user,admin);
    	return users;
    }
}
