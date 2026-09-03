package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.LoginBean;
import com.model.UserBean;
import com.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public ModelAndView showLoginForm() {
		return new ModelAndView("user_login","loginObj",new LoginBean());
	}
	
	@PostMapping("/login")
	public String checkLogin(@ModelAttribute("loginObj")LoginBean obj,RedirectAttributes ra,HttpSession session) {
		UserBean userObj=userRepo.checkLogin(obj.getName());
		if(userObj==null) {
			ra.addFlashAttribute("error","Invalid User!");
//			m.addAttribute("error","Invalid User!");
			return "redirect:user/form";
		}else {
			session.setAttribute("login_user", userObj);
			return "redirect:category/list";
		}
		
		
	}

}
