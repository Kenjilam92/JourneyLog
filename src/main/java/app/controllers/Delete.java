package app.controllers;

import app.services.JourneyServices;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("delete")
public class Delete {
//	private UserServices userService;
	private JourneyServices journeyService;
	
//	@Autowired
//	public void UserService(UserServices userService) {
//		this.userService = userService;
//	}

    @DeleteMapping("users/{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		System.out.println("Post Delete User");
		return null;
		//userService.removeUser(u);
		//return ResponseEntity.noContent().build();
	}

    @DeleteMapping("location/{id}")
	public ResponseEntity deleteLocation(@PathVariable Integer id) {
		System.out.println("Post Delete Location");
		return null;
		//userService.removeLocation(l);
		//return ResponseEntity.noContent().build();
	}

    @DeleteMapping("journey/{id}")
	public ResponseEntity deleteJourney(@PathVariable Integer id) {
		System.out.println("Post Delete Journey");
		return null;
		//userService.removeJourney(j);
		//return ResponseEntity.noContent().build();
	}
}
