package pandey.ujjwal.MovierReviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class MovierReviewerApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
//	public class MovierReviewerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovierReviewerApplication.class, args);
	}
}