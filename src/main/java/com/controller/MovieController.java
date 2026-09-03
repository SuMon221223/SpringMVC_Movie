package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.SelectedMovieRequestDTO;
import com.model.MovieBean;
import com.model.UserBean;
import com.repository.MovieRepository;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieRepository movRepo;
	
	@GetMapping("/getbyid/{catId}")
	public String getById(@PathVariable("catId")Integer catId,Model m,HttpSession session) {
		
		UserBean loginUser = (UserBean) session.getAttribute("login_user");
		if(loginUser!=null) {
			List<MovieBean> list = movRepo.getMoviesByCatId(catId);
			m.addAttribute("movieList",list);
			
			SelectedMovieRequestDTO dto = new SelectedMovieRequestDTO();
			dto.setUserId(loginUser.getId());
			m.addAttribute("usermovieObj",dto);
			return "movie_list";
		}else {
			return "redirect:/";
		}
		
		
		
		
	}
	

}
