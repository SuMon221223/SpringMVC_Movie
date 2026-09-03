package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.CategoryBean;
import com.model.MovieBean;
import com.repository.CategoryRepository;
import com.repository.MovieRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private MovieRepository movRepo;
		
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/category_list")
	public String getAllCategories(Model m) {

		List<CategoryBean> list = catRepo.getAllCategories();
		m.addAttribute("categoryList", list);
		return "admin_category_list";
	}
	
	@GetMapping("/category_getbyid/{id}")
	public ModelAndView getById(@PathVariable("id") Integer catId) {
		CategoryBean obj = catRepo.getById(catId);

		return new ModelAndView("category_edit", "catObj", obj);

	}
	
	@PostMapping("/category_update")
	public String updateCategory(@ModelAttribute("catObj")CategoryBean obj,Model m) {
	
		int i = catRepo.UpdateCategory(obj);
		if(i>0) {
			return "redirect:/admin/category_list";
		}else {
			m.addAttribute("error", "Update Fail!");
			return "category_edit";
		}
		
	}
	
	@GetMapping("/category_remove/{id}")//{id} -> @path variable 
	public String removeCategory(@PathVariable("id")Integer id,Model m) {
		int i = catRepo.RemoveCategory(id);
		
		if(i==0) {
			m.addAttribute("error", "Remove Fail!");	
		}
		return "redirect:/admin/category_list";
	}
	
	@GetMapping("/movie_list")
	public String getAllMovies(Model m) {
	    List<MovieBean> list = movRepo.getAllMovies();
	    m.addAttribute("movieList", list);
	    return "admin_movie_list";
	}
	
	@GetMapping("/movie_getbyid/{id}")
	public ModelAndView getMovieById(@PathVariable("id") Integer id) {

	    MovieBean obj = movRepo.getMovieById(id);

	    return new ModelAndView("movie_edit", "movieObj", obj);
	}
	
	@PostMapping("/movie_update")
	public String updateMovie(
	        @ModelAttribute("movieObj") MovieBean obj,
	        Model m) {

	    int i = movRepo.UpdateMovie(obj);

	    if (i > 0) {
	        return "redirect:/admin/movie_list";
	    } else {
	        m.addAttribute("error", "Movie Update Fail!");
	        return "movie_edit";
	    }
	}
	@GetMapping("/movie_remove/{id}")
	public String removeMovie(@PathVariable("id") Integer id) {

	    movRepo.removeMovie(id);

	    return "redirect:/admin/movie_list";
	}
	
}
