package pandey.ujjwal.MovierReviewer.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pandey.ujjwal.MovierReviewer.pojo.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
