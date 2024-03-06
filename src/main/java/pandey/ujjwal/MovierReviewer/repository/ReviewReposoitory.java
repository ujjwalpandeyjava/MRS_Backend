package pandey.ujjwal.MovierReviewer.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pandey.ujjwal.MovierReviewer.pojo.Review;

@Repository
public interface ReviewReposoitory extends MongoRepository<Review, ObjectId> {
}