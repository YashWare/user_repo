package com.UMS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UMS.model.User;
import com.UMS.repository.UserRepository;
import com.UMS.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User saveUser = userRepository.save(user);
		return saveUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public User updateUser(User user) {
		User updateUser = userRepository.save(user);
		return updateUser;
	}

	@Override
	public void deleteUser(Integer id) {

		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User user = findById.get();
			userRepository.delete(user);
		}
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User user = findById.get();
			return user;
		}
		return null;
	}

}
