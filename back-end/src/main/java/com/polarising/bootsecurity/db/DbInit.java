package com.polarising.bootsecurity.db;

import org.springframework.stereotype.Service;

import com.polarising.bootsecurity.model.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void run(String... args) {
		
		User user = new User("user", passwordEncoder.encode("user"),"USER","");
		User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
		
		List<User> users = Arrays.asList(user,admin);
		
		// Save to database
		this.userRepository.saveAll(users);
	}
}
