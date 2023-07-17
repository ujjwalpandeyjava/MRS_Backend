package pandey.ujjwal.MovierReviewer.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.service.MovieService;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping(path = "/")
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> allMovies = (List<Movie>) movieService.allMovies();
		Iterator<Movie> iterator = allMovies.iterator();
		while (iterator.hasNext()) {
			Movie m = (Movie) iterator.next();
			System.out.println(m);
		}
		System.out.println(allMovies.size());
		return new ResponseEntity<List<Movie>>(allMovies, HttpStatus.OK);
	}

}