package pandey.ujjwal.MovierReviewer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger slf4jLogger = LoggerFactory.getLogger(MovieController.class);

	@GetMapping(value = "/allMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		slf4jLogger.info("Inside the getAllMovies.");
//		if (true)// Testing global exception handling
//			throw new NullPointerException("Testing Global ExceptionHandling");
//		return new ResponseEntity<List<Movie>>(movieServiceInter.allMovies(), HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(movieServiceInter.allMovies());
	}

	@GetMapping(value = "")
	public ResponseEntity<Map<String, Object>> findFirstXMoviesAfterSkippingYMovies(
			@RequestParam(value = "page", defaultValue = "0") String page,
			@RequestParam(value = "next", defaultValue = "5") String next) {
		slf4jLogger.info("Inside the findFirstXMoviesAfterSkippingYMovies.");
		System.out.printf("===> %s ,%s, ", page, next );
		try {
			Integer pageNo = Integer.parseInt(page);
			Integer nextN = Integer.parseInt(next);
			return new ResponseEntity<Map<String, Object>>(movieServiceInter.latestXSkippingY(pageNo, nextN),
					HttpStatus.OK);
		} catch (Exception e) {
			slf4jLogger.error("Had error while parsing the values to int findFirstXMoviesAfterSkippingYMovies: "+ e.getMessage());
			System.out.println(e.getMessage());
			var returnVal = new HashMap<String, Object>();
			returnVal.put("error", "'page' and 'next' has to be a number");
			return new ResponseEntity<Map<String, Object>>(returnVal, HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = "/movieId")
	public ResponseEntity<Optional<Movie>> getOneMovieById(@RequestParam("movieId") ObjectId movieId) {
		return new ResponseEntity<Optional<Movie>>(movieServiceInter.getOneMovieById(movieId), HttpStatus.OK);
	}

	@GetMapping(value = "/imdbID")
	public ResponseEntity<Optional<Movie>> getMovieByImdbID(@RequestParam("imdbID") String imdbID) {
		return new ResponseEntity<Optional<Movie>>(movieServiceInter.getOneMovieByImdbId(imdbID), HttpStatus.OK);
	}

	@GetMapping(value = "/allMoviesContaining")
	public ResponseEntity<List<Movie>> getAllMoviescontaingName(@RequestParam("nameContaining") String nameContaining) {
		return new ResponseEntity<List<Movie>>(movieServiceInter.findAllMovieByNameContaining(nameContaining),
				HttpStatus.OK);
	}

	// Defult parameters to not throw error and similars.
	// But we need for custom response.
	@GetMapping(value = "/searchPagedMoviesContainingName")
	public ResponseEntity<Map<String, Object>> getAllMoviescontaingName(
			@RequestParam(value = "nameContaining", defaultValue = "") String nameContaining,
			@RequestParam(value = "pageNo", defaultValue = "0") String pageNo,
			@RequestParam(value = "rowInAPage", defaultValue = "3") String rowInAPage) {
		System.out.println(nameContaining + "_" + pageNo + "_" + rowInAPage);
		try {
			Integer pageNo_ = Integer.parseInt(pageNo);
			Integer rowInAPage_ = Integer.parseInt(rowInAPage);
			if (rowInAPage_ < 0 || pageNo_ < 0) {
				var returnVal = new HashMap<String, Object>();
				returnVal.put("error", "'pageNo' and 'rowInAPage' has to be a positive number!");
				return new ResponseEntity<Map<String, Object>>(returnVal, HttpStatus.FORBIDDEN);
			} else
				return new ResponseEntity<Map<String, Object>>(movieServiceInter
						.findPagedMovieByNameContainingSkipXBeforeGetY(nameContaining, pageNo_, rowInAPage_),
						HttpStatus.OK);
		} catch (Exception e) {
			var returnVal = new HashMap<String, Object>();
			returnVal.put("error", "'pageNo' and 'rowInAPage' has to be a number");
			return new ResponseEntity<Map<String, Object>>(returnVal, HttpStatus.CONFLICT);
		}

	}
}