package com.devsuperior.movieflix.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewPostDto;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewsController {
	
	@Autowired
	private ReviewService reviewService;
		
	@PostMapping 
	@PreAuthorize("hasAnyRole('ROLE_MEMBER')")
	public ResponseEntity<List<ReviewDTO>> newReview(@Valid @RequestBody ReviewPostDto reviewPostDto) {
		this.reviewService.newReview(reviewPostDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.reviewService.findReview(reviewPostDto.getMovieId()));
	}
}
