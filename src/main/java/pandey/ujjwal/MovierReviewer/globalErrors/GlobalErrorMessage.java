package pandey.ujjwal.MovierReviewer.globalErrors;

import org.springframework.http.HttpStatus;

public class GlobalErrorMessage {
	private String message = "GlobalErrorMessage";
	private HttpStatus httpStatus;

	public GlobalErrorMessage() {
		super();
	}

	public GlobalErrorMessage(String message) {
		super();
		this.message = message;
	}

	public GlobalErrorMessage(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.setHttpStatus(httpStatus);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
