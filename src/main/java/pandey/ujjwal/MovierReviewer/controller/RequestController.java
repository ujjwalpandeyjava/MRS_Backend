package pandey.ujjwal.MovierReviewer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pandey.ujjwal.MovierReviewer.pojo.RequestedTitle;
import pandey.ujjwal.MovierReviewer.service.RequestService;

@RestController
@RequestMapping(value = "/api/v1/request")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class RequestController {

	@Autowired
	private RequestService requestServiceInter;

	// We want para from user, check for default on movie controller
	@PostMapping(value = "")
	public ResponseEntity<RequestedTitle> addRequestTitle(@Valid @RequestBody RequestedTitle requestedBody)
			throws MethodArgumentNotValidException, HttpMessageNotReadableException {
		return new ResponseEntity<RequestedTitle>(requestServiceInter.saveNewRequest(requestedBody), HttpStatus.OK);
	}

	// Class scoped
	@ExceptionHandler({ MethodArgumentNotValidException.class, IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleValidationExceptions(Exception ex) {
		Map<String, String> errors = new HashMap<>();
		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException ex1 = (MethodArgumentNotValidException) ex;
			ex1.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			});
		} else if (ex instanceof IOException) {
			IOException ex1 = (IOException) ex;
			errors.put("Message", "IO e : " + ex1.getMessage());
		}
		return errors;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleNOArgFoundExceptions(HttpMessageNotReadableException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("Reason", "No argument found, Title is must!");
		return errors;
	}
}
