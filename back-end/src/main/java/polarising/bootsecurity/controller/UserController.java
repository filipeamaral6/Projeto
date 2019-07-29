package polarising.bootsecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polarising.bootsecurity.db.UserRepository;
import polarising.bootsecurity.model.User;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }
    
    @GetMapping("users")
    public List<User> users() {
    	return this.userRepository.findAll();
    }
}
