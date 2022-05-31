package com.gocomet.webcrawler.service;

import java.util.List;

import com.gocomet.webcrawler.entity.User;

public interface UserService {

	public List<User> findAll();

	public void save(User role);

	public User getUserByUsername(String username);

}
