package pandey.ujjwal.MovierReviewer.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;

import pandey.ujjwal.MovierReviewer.pojo.Movie;

public interface MovieService {
	public List<Movie> allMovies();

	public Map<String, Object> latestXSkippingY(int page, int next);

	public List<Movie> findAllMovieByNameContaining(String name);

	public Map<String, Object> findPagedMovieByNameContainingSkipXBeforeGetY(String nameContaining, int pageNo,
			int rowInAPage);

	public Optional<Movie> getOneMovieById(ObjectId movieId);

	public Optional<Movie> getOneMovieByImdbId(String movieId);
}
