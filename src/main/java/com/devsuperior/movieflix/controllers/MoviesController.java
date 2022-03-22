package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MoviePerGenreDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MoviesController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MoviePerGenreDTO>> findAllPaged(
			@RequestParam(name = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable) {
		return ResponseEntity.ok().body(this.service.findByGenre(genreId, pageable));
	}
	
	@GetMapping(value = "/{movieId}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long movieId) {
		return ResponseEntity.ok().body(this.service.findById(movieId));
	}
	
	@GetMapping(value = "/{movieId}/reviews")
	public ResponseEntity<List<ReviewDTO>> findReviewsByMovieId(@PathVariable Long movieId) {
		return ResponseEntity.ok().body(this.service.findReviewsByMovieId(movieId));
	}
	
}
