package com.gocomet.webcrawler.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocomet.webcrawler.entity.Role;
import com.gocomet.webcrawler.repository.RoleRepository;
import com.gocomet.webcrawler.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Set<Role> getByNames(String... name) {
		return roleRepository.getByNames(name);
	}

}
