package pandey.ujjwal.MovierReviewer.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.service.MovieService;

@RestController
@RequestMapping(value = "/api/v1/movies")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class MovieController {

	@Autowired
	private MovieService movieServiceInter;

	@GetMapping
	public ResponseEntity<Map<String, Object>> findFirstXMoviesAfterSkippingYMovies(@RequestBody ObjectNode jsonObj) {
		return new ResponseEntity<Map<String, Object>>(movieServiceInter.findFirstXMoviesAfterSkippingYMovies(jsonObj),
				HttpStatus.OK);
	}

	@GetMapping(value = "/allMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieServiceInter.allMovies(), HttpStatus.OK);
	}

	@GetMapping(value = "/movieId")
	public ResponseEntity<Optional<Movie>> getOneMovieById(@RequestParam("movieId") ObjectId movieId) {
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