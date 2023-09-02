package pandey.ujjwal.MovierReviewer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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

	// For home hero
	@Override
	public Map<String, Object> latestXSkippingY(int page, int next) {
		var returnValue = new HashMap<String, Object>();
		returnValue.put("movies", null);
		returnValue.put("moviesCount", 0);
		returnValue.put("possiblePages", 0);

		Query query = new Query();
		query.with(Sort.by(Sort.Direction.DESC, "_id")); // Latest
		query.skip(page * next);
		query.limit(next);

		List<Movie> pagedMovies = mongoTemplate.find(query, Movie.class);
		returnValue.replace("movies", pagedMovies);
		returnValue.replace("moviesCount", pagedMovies.size());

		long count = mongoTemplate.count(new Query(), Movie.class);
		returnValue.replace("possiblePages", ((count / next) + (count % next == 0 ? 0 : 1)));
		Page<Movie> listPagingAndSortingRepositoryReturn = movieRepository.findByTitleContainingIgnoreCase("",
				PageRequest.of(page-1, next));
		returnValue.put("ListPagingAndSorting", listPagingAndSortingRepositoryReturn);
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

	// For search
	@Override
	public Map<String, Object> findPagedMovieByNameContainingSkipXBeforeGetY(String nameContaining, int pageNo,
			int rowInAPage) {
		var returnValue = new HashMap<String, Object>();
		returnValue.put("movies", null);
		returnValue.put("moviesCount", 0);
		returnValue.put("possiblePages", 0);

		Query query = new Query();
		// i=case-insensitive, remove field for case-sensitive
		query.addCriteria(Criteria.where("title").regex(nameContaining, "i"));
		query.skip(pageNo * rowInAPage);
		query.limit(rowInAPage);

		List<Movie> pagedMovies = mongoTemplate.find(query, Movie.class);
		returnValue.replace("movies", pagedMovies);
		returnValue.replace("moviesCount", pagedMovies.size());

		long count = mongoTemplate.count(new Query(), Movie.class);
		returnValue.replace("possiblePages", ((count / rowInAPage) + (count % rowInAPage == 0 ? 0 : 1)));
		return returnValue;

	}
}