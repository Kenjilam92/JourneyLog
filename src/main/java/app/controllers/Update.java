package app.controllers;
import app.models.*;
import app.services.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("update")
public class Update {
//	private UserServices userService;
	private JourneyServices journeyService;
	
//	@Autowired
//	public void UserService(UserServices userService) {
//		this.userService = userService;
//	}

	@PutMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateUser() {
		System.out.println("Post Update User");
		//if(userService.updateUser(new User()))
			return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
		//else
		//	return null;
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
