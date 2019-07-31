package com.polarising.bootsecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.db.UserRepository;
import com.polarising.bootsecurity.model.User;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    @GetMapping("admin")
    public String test1(){
        return "Admins only";
    }

    @GetMapping("user")
    public String test2(){
        return "Users only";
    }
    
    @GetMapping("users")
    public List<User> users() {
    	return this.userRepository.findAll();
    }
}
