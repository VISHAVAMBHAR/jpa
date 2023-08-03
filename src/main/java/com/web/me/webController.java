package com.web.me;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class webController {
	@RequestMapping(method = RequestMethod.GET, value = "/webapp")
	private ModelAndView webapp()
	{
		System.out.println("my web app");
		ModelAndView mv= new ModelAndView();
		System.out.println("my web app");
		mv.setViewName("webapp");
		mv.addObject("name","VISHAVAMBHAR");
        return mv;
	}
	@RequestMapping(method = RequestMethod.GET,value = "hello")
	public String name() 
	{
		return "hello";
		
	}

}
