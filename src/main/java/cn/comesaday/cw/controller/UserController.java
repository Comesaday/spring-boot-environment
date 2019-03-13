package cn.comesaday.cw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.comesaday.cw.domain.User;
import cn.comesaday.cw.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		return new ModelAndView("login");
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="account")String account, @RequestParam(value="password")String password) {
		User user  = userService.login(account, password);
		if (user != null) {
			return new ModelAndView("index");
		}
		return new ModelAndView("error");
	}
}
