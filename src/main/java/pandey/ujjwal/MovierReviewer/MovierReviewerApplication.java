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
		// Now all the logs will be shown on the logger file in the log folder date wise.
		// Remove the logback.xml or change name to something else	
		
		/* After adding in pom.xml: 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-actuator-autoconfigure</artifactId>
			<!--<version>3.1.3</version>-->
		</dependency>
		open url/actuator.
		*/
	}
}