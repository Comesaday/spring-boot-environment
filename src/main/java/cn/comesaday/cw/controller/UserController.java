package cn.comesaday.cw.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.comesaday.cw.domain.User;
import cn.comesaday.cw.service.UserService;
import cn.comesaday.cw.utils.PageBean;

@Controller
public class UserController
{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		
		return "login";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value="account")String account, 
			@RequestParam(value="password")String password) {
		User user  = userService.login(account, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "index";
		}
		return "error";
	}
	
	@RequestMapping("/viewUser")
	public String viewUser(Model model,@RequestParam(value="currentPage") int currentPage) {
		List<User> users = userService.findAll();
		List<User> list = userService.findByPage(currentPage);
		
		PageBean<User> pageBean = new PageBean<>(users.size(), currentPage, list);
		model.addAttribute("pageBean", pageBean);
		
		return "view";
	}
	
	@RequestMapping("/del")
	public String del(@RequestParam(value="id") int id, @RequestParam(value="currentPage") int currentPage) {
		userService.del(id);
		
		return "redirect:/viewUser?currentPage="+currentPage;
	}
	
	@RequestMapping("/initPage")
	public String initPage() {
		
		return "success";
	}
}
