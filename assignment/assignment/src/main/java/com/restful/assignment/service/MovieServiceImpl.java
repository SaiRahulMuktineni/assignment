package com.restful.assignment.service;

import java.util.ArrayList;
import java.util.List;

import com.restful.assignment.model.Movie;

/**
 * Service implementation class to handle the business functionality/logic related to the Movie
 */
public class MovieServiceImpl implements MovieService {

	private static List<Movie> movieList = new ArrayList<Movie>(
			List.of(new Movie("M01", "Top Gun", "Tom Cruise", 350000000.00f),
					new Movie("M02", "Free Guy", "Ryan Reynolds", 270000000.00f),
					new Movie("M03", "Infinite", "Mark Wahlberg", 200000000.00f),
					new Movie("M04", "No Time to Die", "Daniel Craig", 500000000.00f),
					new Movie("M05", "Red Notice", "Dwayne Johnson", 700000000.00f),
					new Movie("M06", "Don't Look Up", "Leonardo DiCaprio", 400000000.00f),
					new Movie("M07", "Black Widow", "Scarlett Johansson", 900000000.00f),
					new Movie("M08", "The Protege", "Maggie Q", 800000000.00f),
					new Movie("M09", "Malignant", "Annabelle Wallis", 600000000.00f),
					new Movie("M10", "The Unforgivable", "Sandra Bullock", 650000000.00f)));

	/**
	 * Method to retrieve list of all movies
	 */
	@Override
	public List<Movie> getMovies() {
		return movieList;
	}

	/**
	 * Method to retrieve a movie based on the given movieId
	 */
	@Override
	public Movie getMovieById(String movieId) {

		Movie movie = new Movie();
		for (final Movie mov : movieList) {
			if (mov.getMovieId().equalsIgnoreCase(movieId)) {
				movie = mov;
				break;
			}
		}
		return movie;
	}

}
