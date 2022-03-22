package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewPostDto;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private MovieService movieService;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private AuthService authService;

	public ReviewDTO newReview(ReviewPostDto reviewPostDto) {
		Review review = new Review();
		review.setText(reviewPostDto.getText());
		review.setMovie(this.movieService.findMovie(reviewPostDto.getMovieId()));
		User user = this.authService.authenticated();
		review.setUser(user);
		this.reviewRepository.save(review);
		return new ReviewDTO(review);
	}
}
