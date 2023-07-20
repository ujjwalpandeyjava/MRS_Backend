package pandey.ujjwal.MovierReviewer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/", "" })
public class ActualMasterController {

	@GetMapping
	@PostMapping
	public ResponseEntity<String> atRoot() {
		String respose = "Maste URI.";
		return new ResponseEntity<String>(respose, HttpStatus.OK);
	}

}
