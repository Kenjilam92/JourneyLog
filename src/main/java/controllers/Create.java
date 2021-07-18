package controllers;
//import models.*;

import services.JourneyService;
import services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/create")
public class Create {

//    @Autowired
//    public void UserService(UserService userService) {
//        this.userService = userService;
//    }

    // Register User
    @PostMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody User u) throws URISyntaxException {
        System.out.println("Post register user");
        return null;
//        UserService.register(u);
//        return ResponseEntity.created(new URI("" + u.getId())).build();
    }
//
//    // Add New Location
//    @PostMapping(path="locations", consumes=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity addLocation(@RequestBody User l) throws URISyntaxException {
//        System.out.println("Post add location");
//        return null;
////        UserService.addLocation(l);
////        return ResponseEntity.created(new URI("" + l.getId())).build();
//    }
//
//    // Add New Journey
//    @PostMapping(path="journeys", consumes=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity addJourney(@RequestBody Journey j) throws URISyntaxException {
//        System.out.println("Post add journey");
//        return null;
////        JourneyService.addJourney(j);
////        return ResponseEntity.created(new URI("" + j.getId())).build();
//    }
}
