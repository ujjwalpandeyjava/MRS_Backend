package pandey.ujjwal.MovierReviewer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = { "/", "" })
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class ViewController {

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<String> atRoot() {
		return new ResponseEntity<String>("Maste URI..", HttpStatus.OK);
	}

	@GetMapping("/home")
	public String home() {
		System.out.println("Inside home() for /home");
		return "home"; // Returns the "home.html" template
	}

	@GetMapping("/home2")
	public String home2() {
		System.out.println("Inside home2() for /home2");
		return "view/viewHome"; // Returns the "view/viewHome.html" template
	}

	@RequestMapping(value = "/jsonResp1", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> responseBody1() {
		System.out.println("Inside responseBody1() for /jsonResp1");
		return new ResponseEntity<String>("URI jsonResp1...", HttpStatus.OK);
	}

	@RequestMapping(value = "/jsonResp2", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String responseBody2() {
		System.out.println("Inside responseBody2() for /jsonResp2");
		return "URI jsonResp2...";
	}

	@RequestMapping(value = "/index1", method = { RequestMethod.GET, RequestMethod.POST })
	public String index1(Model model) {
		System.out.println("Inside index1(model) for /index1");
		model.addAttribute("message", "HELLO from via attribute");
		return "indexHTMLPage"; // Serves' indexHTMLPage.html from resources/templates
	}
}