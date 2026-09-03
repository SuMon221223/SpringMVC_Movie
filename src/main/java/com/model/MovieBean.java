package com.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieBean {
	
	private int id;
	private String title;
	private String description;
//	 @DateTimeFormat(pattern = "/MM/dd/yyyy")//2021-12-25// yyyy/MM/dd
	private LocalDate releaseYear;
	private String duration;
	private int categoryId;

}
