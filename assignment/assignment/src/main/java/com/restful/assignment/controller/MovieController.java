package com.restful.assignment.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.assignment.model.Movie;
import com.restful.assignment.service.MovieService;
import com.restful.assignment.service.MovieServiceImpl;

/**
 * Controller that handles requests related to Movie
 */
@RestController
public class MovieController {

	public MovieService movieService = new MovieServiceImpl();

	/**
	 * API to return list of movies
	 *
	 * @return {@link #List<Movie>}
	 */
	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = { MediaType.TEXT_XML,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}

	/**
	 * API to return a particular movie by movieId
	 *
	 * @param movieId movie identifier
	 * @return {@link #Movie}
	 */
	@RequestMapping(value = "movies/{movieId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
	public Movie getMovieById(@PathVariable(value = "movieId") final String movieId) {
		return movieService.getMovieById(movieId);
	}

}
