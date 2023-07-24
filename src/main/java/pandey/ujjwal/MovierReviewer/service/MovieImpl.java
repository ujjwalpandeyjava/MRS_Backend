package pandey.ujjwal.MovierReviewer.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.repository.MovieRepository;

@Service
public class MovieImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findAllMovieByNameContaining(String name) {
		return movieRepository.findAllMovieByNameContaining(name);
	};

	@Override
	public Optional<Movie> getOneMovieById(ObjectId movieId) {
		return movieRepository.findById(movieId);
	}

	@Override
	public Optional<Movie> getOneMovieByImdbId(String imdbIdMovieId) {
		return movieRepository.findByImdbId(imdbIdMovieId);
	}
}