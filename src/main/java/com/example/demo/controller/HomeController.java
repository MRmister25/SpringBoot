package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DaoController;
import com.example.demo.model.UserDetails;

@Controller
public class HomeController {

	@Autowired
	DaoController dao;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/signup")
	public String add(UserDetails user)
	{
		dao.save(user);
		return "login";
	}
	@RequestMapping("/check")
	public ModelAndView check(@RequestParam("email") String email, @RequestParam("pass") String pass)
	{
		ModelAndView mv=new ModelAndView();
		List<UserDetails> user=dao.loginchecker(email, pass);
		if( !user.isEmpty())
		{
			mv.addObject("username",user.get(0).getUsername());
			mv.setViewName("success");
		}
		else
		{
			String message="invalid credentials";
			mv.addObject("errorMessage", message);
			mv.setViewName("login");
		}
		
		return mv;
	}
	

}
