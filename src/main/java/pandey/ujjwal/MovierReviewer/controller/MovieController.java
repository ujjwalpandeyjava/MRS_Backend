package pandey.ujjwal.MovierReviewer.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.service.MovieService;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService movieServiceInter;

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieServiceInter.allMovies(), HttpStatus.OK);
	}

	@GetMapping(value = "/movieId")
	public ResponseEntity<Optional<Movie>> getOneMovieById(@RequestParam("movieId") ObjectId movieId) {
		System.out.println("One movie with movie ObjectId: " + movieId.toString());
		return new ResponseEntity<Optional<Movie>>(movieServiceInter.getOneMovieById(movieId), HttpStatus.OK);
	}

	@GetMapping(value = "/imdbID")
	public ResponseEntity<Optional<Movie>> getMovieByImdbID(@RequestParam("imdbID") String imdbID) {
		return new ResponseEntity<Optional<Movie>>(movieServiceInter.getOneMovieByImdbId(imdbID), HttpStatus.OK);
	}

	@GetMapping(value = "/nameContaining")
	public ResponseEntity<List<Movie>> getAllMoviescontaingName(@RequestParam("nameContaining") String nameContaining) {
		return new ResponseEntity<List<Movie>>(movieServiceInter.findAllMovieByNameContaining(nameContaining),
				HttpStatus.OK);
	}

}