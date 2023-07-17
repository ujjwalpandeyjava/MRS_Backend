package pandey.ujjwal.MovierReviewer.pojo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseDate;
	private String trailerLink;
	private List<String> genres;
	private String poster;
	private List<String> backdrops;
	// Store on the Id: manual Referal realtionShip
	@DocumentReference
	private List<Review> reviewIds;

	@Override
	public String toString() {
		return "Movie {id:" + id + ", imdbId:" + imdbId + ", title:" + title + ", releaseDate:" + releaseDate
				+ ", trailerLink:" + trailerLink + ", genres:" + genres + ", poster:" + poster + ", backdrops:"
				+ backdrops + ", reviewsIds:" + reviewIds + "}\n";
	}

}
