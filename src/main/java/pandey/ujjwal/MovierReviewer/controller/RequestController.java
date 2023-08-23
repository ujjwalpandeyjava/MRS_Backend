package pandey.ujjwal.MovierReviewer.controller;

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

	@PostMapping(value = "")
	public ResponseEntity<RequestedTitle> addRequestTitle(@Valid @RequestBody RequestedTitle requestedBody)
			throws MethodArgumentNotValidException, HttpMessageNotReadableException {
		return new ResponseEntity<RequestedTitle>(requestServiceInter.saveNewRequest(requestedBody), HttpStatus.OK);
	}

	// Class scoped
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		System.out.println("Inside BAD Request exception handling");
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
