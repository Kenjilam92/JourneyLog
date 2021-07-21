package app.controllers;

import app.models.*;
import app.services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("delete")
public class Delete {
//	private UserServices userService;
	private JourneyServices journeyService;
	
//	@Autowired
//	public void UserService(UserServices userService) {
//		this.userService = userService;
//	}

    @DeleteMapping(path="users/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteUser(@PathVariable Integer id, @RequestBody Map<String, Object> userData) {
		System.out.println("Post Delete User");
		System.out.println("User ID: " + userData.get("userId"));
		System.out.println("Password: " + userData.get("password"));

		/*if(userService.deleteUser(userService.getUserById(userData.get("userId")))) {
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}*/

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

    @DeleteMapping(path="location/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteLocation(@PathVariable Integer id, @RequestBody Map<String, Object> locationData) {
		System.out.println("Post Delete Location");
		System.out.println("Location ID: " + locationData.get("locationId"));

		/*if(locationService.deleteLocation(locationService.getLocationById(locationData.get("locationId")))) {
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}*/

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

    @DeleteMapping(path="journey/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteJourney(@PathVariable Integer id, @RequestBody Map<String, Object> journeyData) {
		System.out.println("Post Delete Journey");
		System.out.println("Journey ID: " + journeyData.get("journeyId"));

		/*if(journeyService.deleteJourney(journeyService.getJourneyById(journeyData.get("journeyId")))) {
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}*/

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}
}