package controllers;

import models.*;
import services.*;

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
    
    @DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		System.out.println("Post Delete User");
		return null;
		//userService.removeUser(u);
		//return ResponseEntity.noContent().build();
	}
    
    @DeleteMapping("{id}")
	public ResponseEntity deleteLocation(@PathVariable Integer id) {
		System.out.println("Post Delete Location");
		return null;
		//userService.removeLocation(l);
		//return ResponseEntity.noContent().build();
	}

    @DeleteMapping("{id}")
	public ResponseEntity deleteJourney(@PathVariable Integer id) {
		System.out.println("Post Delete Journey");
		return null;
		//userService.removeJourney(j);
		//return ResponseEntity.noContent().build();
	}
}
