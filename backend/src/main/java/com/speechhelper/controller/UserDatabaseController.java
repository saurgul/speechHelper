package com.speechhelper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.speechhelper.databasemanager.UserEntity;
import com.speechhelper.databasemanager.UserRepository;

@Controller
@RequestMapping(path="/speech_helper")
public class UserDatabaseController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/add_user") // Map ONLY POST Requests
	public String addNewUser (@RequestParam String name, @RequestParam String userName, @RequestParam String password, @RequestParam int age ) {
		UserEntity n = new UserEntity();
		n.setName(name);
		n.setUserName(userName);
		n.setPassword(password);
		n.setAge(age);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all/user")
	public Iterable<UserEntity> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userRepository.findAll();
	}
	
	@GetMapping(path="/user_id/{:userId}")
	public UserEntity findByUserId(@Param("userId") Long userId) {
		return userRepository.findById(userId).get();
	}
}
