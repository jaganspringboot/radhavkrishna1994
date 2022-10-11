package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.bean.Book;

@Controller
public class TestController {

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello()
	{
		return "This is a test controller";
	}
	
	@RequestMapping("/")
	public String welcome()
	{
		return "welcome.jsp";
	}
	
	@RequestMapping("/home")
	public String home(@RequestParam("username") String username,ModelMap map)
	{
		Book book=new Book(1234l, "C", 150.25);
		map.addAttribute("book", book);
		
		map.addAttribute("username", username);
		return "home.jsp";
	}
	
}
