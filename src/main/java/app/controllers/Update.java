package app.controllers;
import app.models.*;
import app.services.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("update")
public class Update {
	private UserServices userService = UserServices.getServices();
	private JourneyServices journeyService = JourneyServices.getServices();
	private LocationServices locationServices = LocationServices.getServices();

//	@Autowired
//	public void (UserServices userService) {
//		this.userService = userService;
//	}


	@PutMapping(path="users/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody Map<String, Object> userData) {

//		System.out.println("Post Update User");
//		System.out.println("First Name: " + userData.get("firstName"));
//		System.out.println("Last Name: " + userData.get("lastName"));
//		System.out.println("Email: " + userData.get("email"));
//		System.out.println("Password: " + userData.get("password"));

		User updateUser = userService.getUserById(id);

		if(updateUser != null) {
			updateUser.setFirstName( (String) userData.get("firstName") );
			updateUser.setLastName( (String) userData.get("lastName") );
			updateUser.setEmail( (String) userData.get("email") );
			updateUser.setPassword( (String) userData.get("password") );

			if (userService.updateUser(updateUser))
				return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

	@PutMapping(path="location/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateLocation(@PathVariable Integer id, @RequestBody Map<String, Object> locationData) {
//		System.out.println("Post Update Location");
//		System.out.println("Street Number: " + locationData.get("streetNumber"));
//		System.out.println("Street Name: " + locationData.get("streetName"));
//		System.out.println("City: " + locationData.get("city"));
//		System.out.println("State: " + locationData.get("state"));
//		System.out.println("Zipcode: " + locationData.get("zipcode"));


		Location updateLocation = locationServices.getLocationById(id);

		if(updateLocation != null) {
			updateLocation.setStreetNumber( (int)locationData.get("streetNumber") );
			updateLocation.setStreetName( (String) locationData.get("streetName") );
			updateLocation.setCity( (String) locationData.get("city") );
			updateLocation.setState( (String) locationData.get("state") );
			updateLocation.setZipcode( (String) locationData.get("zipcode"));

			if (locationServices.updateLocation(updateLocation))
				return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

	@PutMapping(path="journey/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateJourney(@PathVariable Integer id, @RequestBody Map<String, Object> journeyData) {
//		System.out.println("Post Update Journey");
//		System.out.println("Creator ID: " + journeyData.get("creatorId"));
//		System.out.println("Time: " + journeyData.get("time"));
//		System.out.println("Length: " + journeyData.get("length"));

		Journey updateJourney = journeyService.getJourneyById(id);

		if(updateJourney != null) {
			updateJourney.setCreator( userService.getUserById( (int) journeyData.get("creatorId") ) );
			updateJourney.setTime( (int) journeyData.get("time"));
			updateJourney.setLength( (int) journeyData.get("length"));

			if (journeyService.updateJourney(updateJourney))
				return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		}

		return new ResponseEntity<>("{ \"connected\" : false, \"status\" : \"failure\" }", HttpStatus.OK);
	}

}
