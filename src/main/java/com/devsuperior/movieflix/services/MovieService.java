package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MoviePerGenreDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public Page<MoviePerGenreDTO> findByGenre(Long genreId, Pageable pageable) {
		Genre genre = (genreId == 0) ? null : this.genreRepository.getOne(genreId);
		return this.movieRepository.findByGenre(genre, pageable).map(MoviePerGenreDTO::new);
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long movieId) {

		Movie movie = this.findMovie(movieId);
		return new MovieDTO(movie);

	}
		
	@Transactional(readOnly = true)
	public List<ReviewDTO> findReviewsByMovieId(Long movieId) {
		return this.findMovie(movieId).getReviews().stream().map(ReviewDTO::new).collect(Collectors.toList());
	}

	public Movie findMovie(Long movieId) {
		Optional<Movie> result = this.movieRepository.findById(movieId);
		Movie movie = result.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return movie;
	}
}