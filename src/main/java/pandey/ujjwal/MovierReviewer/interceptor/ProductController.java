package pandey.ujjwal.MovierReviewer.interceptor;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/interceptorEg/products", "/withAuth/interceptorEg/products" }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class ProductController {

	@GetMapping(value = { "", "/" })
	public ResponseEntity<String> getHome() {
		return ResponseEntity.ok("You are at interceptor example home URL");
	}

	@GetMapping(path = "/list")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products2 = new ArrayList<>(List.of(new Product(0, "--", 112.0), new Product(1, "--", 13.0)));
		return new ResponseEntity<List<Product>>(products2, HttpStatus.OK);
	}

	@PostMapping(value = "/list")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
		return new ResponseEntity<Product>(new Product(1500, "ipad12", 1450.0), HttpStatus.OK);
	}
}
