package pandey.ujjwal.MovierReviewer.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogHandlerInterceptor()); // All URLs
		registry.addInterceptor(new BasicAuthInterceptor()).addPathPatterns("/withAuth/**");
	}
}