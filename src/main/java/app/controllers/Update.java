package app.controllers;
import app.models.*;
import app.services.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("update")
public class Update {
	private UserServices userService;
	private JourneyServices journeyService;
	
//	@Autowired
//	public void UserService(UserServices userService) {
//		this.userService = userService;
//	}

	@PutMapping(path="users/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody Map<String, Object> userData) {

		System.out.println("Post Update User");
		System.out.println("First Name: " + userData.get("firstName"));
		System.out.println("Last Name: " + userData.get("lastName"));
		System.out.println("Email: " + userData.get("email"));
		System.out.println("Password: " + userData.get("password"));

		/*User updateUser = userService.getUserById(id);

		if(updateUser != null) {
			updateUser.setFirstName(userData.get("firstName"));
			updateUser.setLastName(userData.get("lastName"));
			updateUser.setEmail(userData.get("email"));
			updateUser.setPassword(userData.get("password"));

			if (userService.updateUser(updateUser))
				return new ResponseEntity<>("{ \"connected\" : true," +
													"\"status\" : \"success\" }",
													HttpStatus.OK);
		}*/

		return new ResponseEntity<>("{ \"connected\" : true," +
											"\"status\" : \"failure\" }",
											HttpStatus.OK);
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
