package com.proj.ums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proj.ums.entity.User;
import com.proj.ums.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		userService.addUser(user);
		return ResponseEntity.ok("user created successfully");
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {

		User u = userService.getUser(id);
		if (u == null) {
			return ResponseEntity.ok("user not exist");
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> u = userService.getAllUsers();
		return ResponseEntity.ok(u);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
	    userService.updateUser(user);
	    return ResponseEntity.ok("User updated successfully");
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
	    userService.deleteUser(id);
	    return ResponseEntity.ok("User deleted successfully");
	}
}
