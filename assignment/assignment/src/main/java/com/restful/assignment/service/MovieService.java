package com.restful.assignment.service;

import java.util.List;

import com.restful.assignment.model.Movie;

/**
 * Service class to handle the movie business methods
 */
public interface MovieService {

	public List<Movie> getMovies();
	
	public Movie getMovieById(String movieId);
	
}
