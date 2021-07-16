package controllers;

import models.*;
import services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("update")
public class Update {
	private UserService userService;
	private JourneyService journeyService;
	
	@Autowired
	public void UserService(UserService userService) {
		this.userService = userService;
	}

	@PutMapping(path="users/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User u, @PathVariable Integer id) {
		System.out.println("Post Update User");
		return null;
		//userService.updateUser(u);
		//return ResponseEntity.noContent().build();
	}

	@PutMapping(path="location/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateLocation(@RequestBody Location l, @PathVariable Integer id) {
		System.out.println("Post Update Location");
		return null;
		//userService.updateLocation(l);
		//return ResponseEntity.noContent().build();
	}

	@PutMapping(path="journey/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateJourney(@RequestBody Journey j, @PathVariable Integer id) {
		System.out.println("Post Update Journey");
		return null;
		//userService.updateJourney(j);
		//return ResponseEntity.noContent().build();
	}
}
