package com.qiaw99.AyUser.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiaw99.AyUser.model.AyUser;
import com.qiaw99.AyUser.service.AyUserService;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {
	@Resource
	private AyUserService ayUserService;
	
	@RequestMapping("/test")
	public String test(Model model) {
		List<AyUser> ayUsers = ayUserService.findAll();
		model.addAttribute("users", ayUsers);
		return "ayUser";
	}
}
