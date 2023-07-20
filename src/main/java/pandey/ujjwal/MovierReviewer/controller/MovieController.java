package pandey.ujjwal.MovierReviewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.service.MovieServiceInter;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieServiceInter movieServiceInter;

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieServiceInter.allMovies(), HttpStatus.OK);
	}

}