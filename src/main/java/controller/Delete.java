package src.main.java.controller;

import src.main.java.services.JourneyService;
import src.main.java.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class Delete {
	private UserService userService;
	private JourneyService journeyService;
	
	@Autowired
	public void UserService(UserService userService) {
		this.userService = userService;
	}
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteUser(@RequestBody User u) throws URISyntaxException {
		System.out.println("Post Delete User");
		return null;
		//userService.removeUser(u);
		//return ResponseEntity.created(new URI("" + u.getId())).build();
	}
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteLocation(@RequestBody Location l) throws URISyntaxException {
		System.out.println("Post Delete Location");
		return null;
		//userService.removeLocation(l);
		//return ResponseEntity.created(new URI("" + u.getId())).build();
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteJourney(@RequestBody Journey j) throws URISyntaxException {
		System.out.println("Post Delete Journey");
		return null;
		//userService.removeJourney(j);
		//return ResponseEntity.created(new URI("" + u.getId())).build();
	}
}
