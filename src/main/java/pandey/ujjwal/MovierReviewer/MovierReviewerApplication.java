package pandey.ujjwal.MovierReviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovierReviewerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovierReviewerApplication.class, args);
	}
}