package com.UMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UMS.model.User;
import com.UMS.service.UserService;

//if you use rest api then use restcontroller. it is used to return data in json or xml format
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);

		if (ObjectUtils.isEmpty(saveUser)) {
			return new ResponseEntity<>("User Not Saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		User saveUser = userService.updateUser(user);

		if (ObjectUtils.isEmpty(saveUser)) {
			return new ResponseEntity<>("User Not Update", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> getUser(@PathVariable Integer id) {
		User userById = userService.getUserById(id);
		if (ObjectUtils.isEmpty(userById)) {
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}
}
