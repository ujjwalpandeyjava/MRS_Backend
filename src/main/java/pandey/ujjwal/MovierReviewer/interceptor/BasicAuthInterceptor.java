package pandey.ujjwal.MovierReviewer.interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicAuthInterceptor implements HandlerInterceptor {
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("BasicAuthInterceptor::preHandle()");
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Basic ")) {
			String base64Credentials = authHeader.substring("Basic ".length());
			byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);

			String[] parts = credentials.split(":");
			String username = parts[0];
			String password = parts[1];

			if (USERNAME.equals(username) && PASSWORD.equals(password))
				return true;
		}

		// Comment this line or add Basic Auth to see other methods working
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized message from interceptor, Add Basic Auth Autho");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("BasicAuthInterceptor::postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("BasicAuthInterceptor::afterCompletion()");
	}
}