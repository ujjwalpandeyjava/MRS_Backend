package pandey.ujjwal.MovierReviewer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.repository.MovieRepository;

@Service
public class MovieImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Map<String, Object> findFirstXMoviesAfterSkippingYMovies(ObjectNode jsonObj) {
		var returnValue = new HashMap<String, Object>();
		returnValue.put("movies", null);
		returnValue.put("moviesCount", 0);
		returnValue.put("pages", 0);

		Integer pageNo = 0;
		Integer nextN = 0;

		if (jsonObj.has("page") && jsonObj.get("page").canConvertToInt())
			pageNo = jsonObj.get("page").intValue();
		if (jsonObj.has("next") && jsonObj.get("next").canConvertToInt())
			nextN = jsonObj.get("next").intValue();

		Query query = new Query();
		query.skip(pageNo * nextN);
		query.limit(nextN);

		List<Movie> pagedMovies = mongoTemplate.find(query, Movie.class);
		returnValue.replace("movies", pagedMovies);
		returnValue.replace("moviesCount", pagedMovies.size());

		long count = mongoTemplate.count(new Query(), Movie.class);
		returnValue.replace("pages", ((count / nextN) + (count % nextN == 0 ? 0 : 1)));
		return returnValue;

	}

	@Override
	public List<Movie> findAllMovieByNameContaining(String name) {
		return movieRepository.findAllMovieByNameContaining(name);
	}

	@Override
	public Optional<Movie> getOneMovieById(ObjectId movieId) {
		return movieRepository.findById(movieId);
	}

	@Override
	public Optional<Movie> getOneMovieByImdbId(String imdbIdMovieId) {
		return movieRepository.findByImdbId(imdbIdMovieId);
	}
}