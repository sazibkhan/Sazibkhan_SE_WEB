package com.springbooth.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbooth.model.dto.UserDTO;
import com.springbooth.model.entity.Role;
import com.springbooth.model.entity.User;
import com.springbooth.repo.RoleRepository;
import com.springbooth.repo.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void signUp(UserDTO userDTO) {
		
		
		
	}

	public User saveUser(UserDTO userDTO) {		
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setLastName(userDTO.getLastName());		
		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		user.setActive(1);
		
		Role role = new Role();
		role.setRole("ADMIN");
		role.setUser(user);
		user.setRoles(new HashSet<>(Arrays.asList(role)));
		return userRepository.save(user);
	}

}