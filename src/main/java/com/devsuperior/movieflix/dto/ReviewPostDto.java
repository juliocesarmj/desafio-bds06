package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;

public class ReviewPostDto {
	
	@NotBlank(message = "Informe uma avaliação.")
	private String text;
	private Long movieId;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
}
