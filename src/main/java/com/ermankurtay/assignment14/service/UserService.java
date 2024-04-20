package com.ermankurtay.assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermankurtay.assignment14.domain.User;
import com.ermankurtay.assignment14.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public User createUser(String name) {
		User user = new User();
		user.setName(name);
		return userRepo.saveUser(user);
		
	}
}
