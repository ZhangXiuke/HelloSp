package com.zxk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxk.pojo.UserVo;
import com.zxk.service.UserService;

@Controller
@RequestMapping("/hello")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/sayHello")
	public String SayHello(Model model){
		model.addAttribute("message", "Hello SpringMvc");
		return "hello";
	}
	
	@RequestMapping(value="/TCode")
	public String getAllCode(Model model){
		List<UserVo> users = userService.getAllUser();
		for(UserVo u : users){
			System.out.println(u.getName());
		}
		model.addAttribute("users", users);
		return "user/user";
	}

}
