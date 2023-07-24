package pandey.ujjwal.MovierReviewer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pandey.ujjwal.MovierReviewer.pojo.Review;
import pandey.ujjwal.MovierReviewer.service.ReviewService;

@RestController
@RequestMapping(value = "/api/v1/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	private ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
		if (payload.get("reviewBody") == null)
			return new ResponseEntity<Review>(new Review(), HttpStatus.NOT_MODIFIED); // "No message Found!"

		return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
				HttpStatus.CREATED);
	}
}
