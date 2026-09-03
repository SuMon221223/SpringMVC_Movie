package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.SalutationBean;
import com.model.UserBean;
import com.repository.SalutataionRepository;
import com.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SalutataionRepository salRepo;
	
	@GetMapping("/form")
	public ModelAndView showUserForm(Model m) {
		List<SalutationBean> list = salRepo.getAllSalutaion();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(SalutationBean salObj : list) {
			map.put(salObj.getId(), salObj.getType());
		}
		
		m.addAttribute("list",map);
		return new ModelAndView("user_create","userObj",new UserBean());
	}
	
	@PostMapping("/create")
	public String createUser(@ModelAttribute("userObj")UserBean obj) {
		int i =userRepo.CreateUser(obj);
		if(i>0) {
			return "redirect:/";
		}else {
			return "";
		}
		
	}

}
