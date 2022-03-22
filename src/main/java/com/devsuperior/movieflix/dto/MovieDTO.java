package com.devsuperior.movieflix.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieDTO {
	
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	
	private GenreDTO genre;
		
	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}
	
	public MovieDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		synopsis = entity.getSynopsis();
		genre = new GenreDTO(entity.getGenre());
	}
	
	public MovieDTO(Movie entity, List<Review> reviews) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		synopsis = entity.getSynopsis();
		genre = new GenreDTO(entity.getGenre());
		List<ReviewDTO> reviewsDto = new ArrayList<>();
		reviews.forEach(review -> reviewsDto.add(new ReviewDTO(review)));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public GenreDTO getGenreDTO() {
		return genre;
	}

	public void setGenreDTO(GenreDTO genreDTO) {
		this.genre = genreDTO;
	}	
}
