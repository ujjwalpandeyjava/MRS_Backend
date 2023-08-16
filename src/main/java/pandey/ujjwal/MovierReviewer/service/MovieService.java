package pandey.ujjwal.MovierReviewer.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.node.ObjectNode;

import pandey.ujjwal.MovierReviewer.pojo.Movie;

public interface MovieService {
	public List<Movie> allMovies();

	public List<Movie> findFirstXMoviesAfterSkippingYMovies(ObjectNode jsonObj);

	public List<Movie> findAllMovieByNameContaining(String name);

	public Optional<Movie> getOneMovieById(ObjectId movieId);

	public Optional<Movie> getOneMovieByImdbId(String movieId);
}
