package pandey.ujjwal.MovierReviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovierReviewerApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MovierReviewerApplication.class, args);
	}

	// No need to add project name
	@GetMapping("/")
	public String apiHome() {
		System.out.println(env.getProperty("MONGO_DATABASE"));
		System.out.println(env.getProperty("MONGO_USER"));
		System.out.println(env.getProperty("MONGO_PASSWORD"));
		System.out.println(env.getProperty("MONGO_CLUSTER"));
		return "Hello, Goku";
	}

	@GetMapping("/error")
	public String apiError() {
		return "Hello, Goku, you got an error";
	}
}