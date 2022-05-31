package com.gocomet.webcrawler.service;

import java.util.Set;

import com.gocomet.webcrawler.entity.Role;

public interface RoleService {

	public void save(Role role);

	public Set<Role> getByNames(String... name);

}
