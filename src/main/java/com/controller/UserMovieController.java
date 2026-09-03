package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.SelectedMovieRequestDTO;
import com.dto.SelectedMovieResponseDTO;
import com.model.UserBean;
import com.repository.UserSelectedMovieRepository;

@Controller
public class UserMovieController {
	
	@Autowired
	private UserSelectedMovieRepository umRepo;
	
	@PostMapping("/choose")
	public String chooseMovie(@ModelAttribute("usermovieObj")SelectedMovieRequestDTO obj) {
//		System.out.println("obj : " + obj.getMovieIds().length);
		
		int i = umRepo.rentedMovie(obj.getUserId(), obj.getMovieIds());
		if (i>0) {
			return "redirect:rent-list";
		}else {
			return "";
		}
		
	}
	
	@GetMapping("/rent-list")
	public String getMovies(Model m,HttpSession session) {
		UserBean loginUser = (UserBean) session.getAttribute("login_user");
		if(loginUser!=null) {
			List<SelectedMovieResponseDTO> resList = umRepo.getMoviesByUserId(loginUser.getId());
			m.addAttribute("movieList",resList);
			return "selected_movie";
		}else {
			return "redirect:/";
		}
		
		
	}


}
