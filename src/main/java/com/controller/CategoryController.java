package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.CategoryBean;
import com.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@GetMapping("/form")
	public ModelAndView showForm() {
		return new ModelAndView("category_create","catObj",new CategoryBean());
	}
	
	@PostMapping("/create")
	public String createCategory(@ModelAttribute("catObj")CategoryBean obj,Model m) {
		int i = catRepo.CreateCategory(obj);
		if(i >0) {
			return "redirect:list";
		}else {
			m.addAttribute("error","Insert fail");
			return "category_create";
		}
	}
	@GetMapping("/list")
	public String getAllCategories(Model m,HttpSession session) {
		if(session.getAttribute("login_user")!=null) {
			List<CategoryBean> list=catRepo.getAllCategories();
			m.addAttribute("categoryList",list);
			return "category_list";
		}else {
			return "redirect:/";
		}
		
	}
	

}
