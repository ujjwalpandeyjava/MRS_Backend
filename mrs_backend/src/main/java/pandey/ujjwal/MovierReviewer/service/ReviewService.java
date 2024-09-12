package pandey.ujjwal.MovierReviewer.service;

import pandey.ujjwal.MovierReviewer.pojo.Review;

public interface ReviewService {
	public Review createReview(String reviewBodyText, String imdbId);
}
