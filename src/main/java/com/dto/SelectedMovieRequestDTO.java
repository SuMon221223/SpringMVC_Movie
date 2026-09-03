package com.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectedMovieRequestDTO {
	
	private Integer id;
	private  Integer userId;
	private Integer[] movieIds;

}