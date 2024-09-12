package pandey.ujjwal.MovierReviewer.globalErrors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// package scoped
// @ControllerAdvice(basePackages = "pandey.ujjwal.MovierReviewer.service")
// Global scoped
@ControllerAdvice
@ResponseStatus
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	// Handles perticular type of exceptions.
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<GlobalErrorMessage> globalXException(NullPointerException n) {
		GlobalErrorMessage globalErrorMessage = new GlobalErrorMessage(n.getMessage());
		System.out.println("in exception handling null pointer exception.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(globalErrorMessage);
	}

}
