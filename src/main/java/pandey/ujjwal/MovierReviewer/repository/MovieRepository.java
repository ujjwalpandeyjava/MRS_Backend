package pandey.ujjwal.MovierReviewer.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import pandey.ujjwal.MovierReviewer.pojo.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
	@Query("{'title': { $regex: ?0, $options: 'i' }}")
	List<Movie> findAllMovieByNameContaining(String name);
	
    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);

	/*
	 Auto Queries with properties name, (no need of @Query())
	 @Query: indicates that the method will use a custom query for data retrieval
	 "{'imdbId': ?0}"MongoDB query expression itself
	 ?0: parameter number
	 
	 We can use MongoTemplate also
	 **/
	@Query("{'imdbId': ?0}")
	public Optional<Movie> findByImdbId(String movieId);
	}
