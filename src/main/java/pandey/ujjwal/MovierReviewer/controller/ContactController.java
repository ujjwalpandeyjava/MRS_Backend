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
import pandey.ujjwal.MovierReviewer.pojo.ContactForm;
import pandey.ujjwal.MovierReviewer.service.ContactService;

@RestController
@RequestMapping(value = "/api/v1/contact")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class ContactController {
	@Autowired
	private ContactService contactService;

	@PostMapping(value = "addNewForm")
	public ResponseEntity<ContactForm> addRequestTitle(@Valid @RequestBody ContactForm requestedBody)
			throws MethodArgumentNotValidException, HttpMessageNotReadableException {
		return new ResponseEntity<ContactForm>(contactService.saveNewForm(requestedBody), HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
			IOException.class })
	public Map<String, String> handleValidationExceptions(Exception ex) {
		Map<String, String> errors = new HashMap<>();
		if (ex instanceof HttpMessageNotReadableException) {
//			HttpMessageNotReadableException ex1 = (HttpMessageNotReadableException) ex;
			errors.put("Reason", "No body found, add data in body.");
			return errors;
		} else if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException ex1 = (MethodArgumentNotValidException) ex;
			ex1.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
				errors.put("Error", "Need data to save");
			});
		}
		return errors;
	}
}
