package pandey.ujjwal.MovierReviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import pandey.ujjwal.MovierReviewer.pojo.Movie;
import pandey.ujjwal.MovierReviewer.pojo.Review;
import pandey.ujjwal.MovierReviewer.repository.ReviewReposoitory;
import pandey.ujjwal.MovierReviewer.service.ReviewService;

@Service
public class ReviewImpl implements ReviewService {

	@Autowired
	private ReviewReposoitory reviewReposoitory;

	// Other way to talk to the mongoDB Repository
	// It forms a new dynamic query and do job without repository
	// Use it when the repository does not offer what you need, or not suitable, or Perform method chaining
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Review createReview(String reviewBodyText, String imdbId) {
		Review newReview = new Review(reviewBodyText);
		newReview = reviewReposoitory.insert(newReview);
		
		mongoTemplate.update(Movie.class)
		.matching(Criteria.where("imdbId").is(imdbId))
		.apply(new Update().push("reviewIds").value(newReview)).first();
		return newReview;
	}
}