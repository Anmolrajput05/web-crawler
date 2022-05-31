package com.gocomet.webcrawler.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocomet.webcrawler.entity.User;
import com.gocomet.webcrawler.repository.UserRepository;
import com.gocomet.webcrawler.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

}
