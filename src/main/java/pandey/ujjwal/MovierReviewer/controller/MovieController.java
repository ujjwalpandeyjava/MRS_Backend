package pandey.ujjwal.MovierReviewer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.service.MovieService;

@RestController
@RequestMapping(value = "/api/v1/movies")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class MovieController {

	@Autowired
	private MovieService movieServiceInter;

	@GetMapping(value = "")
	public ResponseEntity<Map<String, Object>> findFirstXMoviesAfterSkippingYMovies(
			@RequestParam(value = "page", defaultValue = "0") String page,
			@RequestParam(value = "next", defaultValue = "5") String next) {
		try {
			Integer pageNo = Integer.parseInt(page);
			Integer nextN = Integer.parseInt(next);
			return new ResponseEntity<Map<String, Object>>(
					movieServiceInter.findFirstXMoviesAfterSkippingYMovies(pageNo, nextN), HttpStatus.OK);
		} catch (Exception e) {
			var returnVal = new HashMap<String, Object>();
			returnVal.put("error", "'page' and 'next' has to be a number");
			return new ResponseEntity<Map<String, Object>>(returnVal, HttpStatus.CONFLICT);
		}
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