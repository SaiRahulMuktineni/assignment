package com.restful.assignment.model;

/**
 * Class to hold information about the Movie details
 *
 */
public class Movie {

	/**
	 * Movie identifier
	 */
	private String movieId;
	
	/**
	 * Name of the movie
	 */
	private String movieName;
	
	/**
	 * Actor who worked in the movie
	 */
	private String movieActor;
	
	/**
	 * The amount that the movie collected
	 */
	private float movieCollection;

	/**
	 * Default constructor
	 */
	public Movie() {
		super();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param movieId movie identifier
	 * @param movieName movie name
	 * @param movieActor movie actor
	 * @param movieCollection amount the movie collected
	 */
	public Movie(String movieId, String movieName, String movieActor, float movieCollection) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieActor = movieActor;
		this.movieCollection = movieCollection;
	}

	/**
	 * Return the movie identifier
	 * 
	 * @return {@link #movieId}
	 */
	public String getMovieId() {
		return movieId;
	}
	
	/**
	 * Set the movie identifier
	 * 
	 * @param movieId movie identifier
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * Return the movie name
	 * 
	 * @return {@link #movieName}
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * Set the movie name
	 * 
	 * @param movieName movie name
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * Return the movie actor
	 * 
	 * @return {@link #movieActor}
	 */
	public String getMovieActor() {
		return movieActor;
	}

	/**
	 * Set the movie actor
	 * 
	 * @param movieActor movie actor
	 */
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	/**
	 * Return the amount collected by the movie
	 * 
	 * @return {@link #movieCollection}
	 */
	public float getMovieCollection() {
		return movieCollection;
	}

	/**
	 * Set the amount collected by the movie
	 * 
	 * @param movieCollection amount collected by the movie
	 */
	public void setMovieCollection(float movieCollection) {
		this.movieCollection = movieCollection;
	}
	
	
}
