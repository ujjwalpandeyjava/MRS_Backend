package pandey.ujjwal.MovierReviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovierReviewerApplication extends SpringBootServletInitializer {
//	public class MovierReviewerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovierReviewerApplication.class, args);
		// Logs in log/log date wise
		// Remove/Rename the logback.xml to see all in console	
		
		/* Actuator dependency to see list of URIs
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-actuator-autoconfigure</artifactId>
		</dependency>
		open url/actuator.
		*/
	}
}