package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO {
	
	private Long id;
	private String text;	
	private Long movieId;
	private UserDTO userDto;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text, UserDTO userDto, Long movieId) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.userDto = userDto;
	}
	
	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movieId = entity.getMovie().getId();
		userDto = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
}
