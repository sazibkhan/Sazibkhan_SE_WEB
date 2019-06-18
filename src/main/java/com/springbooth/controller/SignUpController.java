package com.springbooth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbooth.model.dto.UserDTO;
import com.springbooth.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/signUp")
	public String signUp(Model model) {
		try {
			model.addAttribute("UBI4SignUpDTO", new UserDTO());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "signUp";
	}
	
	@RequestMapping(path = "/index")
	public String index(Model model) {
		
			return "index";
	}
	
	@RequestMapping(path="/userRegistration")
	public String userRegistration(UserDTO userDTO) {
		userService.saveUser(userDTO);
		return "redirect:/";		
	}	
	
}

