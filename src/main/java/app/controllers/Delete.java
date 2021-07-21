package app.controllers;

import app.models.*;
import app.services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("delete")
public class Delete {
	private UserServices userService = UserServices.getServices();
	private JourneyServices journeyServices = JourneyServices.getServices();
	private LocationServices locationServices = LocationServices.getServices();

    @DeleteMapping(path="users", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteUser(@RequestBody Map<String, Object> userData) {
		System.out.println("Post Delete User");
		System.out.println("User ID: " + userData.get("userId"));
		System.out.println("Password: " + userData.get("password"));

		if(userService.deleteUser(userService.getUserById( (int) userData.get("userId")))) {
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

    @DeleteMapping(path="location", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteLocation(@RequestBody Map<String, Object> locationData) {
		System.out.println("Post Delete Location");
		System.out.println("Location ID: " + locationData.get("locationId"));

		if(locationServices.deleteLocation(locationServices.getLocationById( (int) locationData.get("locationId")))) {
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

    @DeleteMapping(path="journey", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteJourney(@PathVariable Integer id, @RequestBody Map<String, Object> journeyData) {
		System.out.println("Post Delete Journey");
		System.out.println("Journey ID: " + journeyData.get("journeyId"));

		if(journeyServices.deleteJourney(journeyServices.getJourneyById( (int) journeyData.get("journeyId") ))) {
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}
}