package pandey.ujjwal.MovierReviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}
}
