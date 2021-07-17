package controllers;

import services.*;
import models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class Create {
    private UserServices userServices;
    private JourneyServices journeyServics;

//    @Autowired
//    public void UserService(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody User u) {
        System.out.println("Post register user");
        return null;
//        UserService.register(u);
//        return ResponseEntity.created(new URI("" + u.getId())).build();
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLocation(@RequestBody User l)  {
        System.out.println("Post add location");
        return null;
//        UserService.addLocation(l);
//        return ResponseEntity.created(new URI("" + l.getId())).build();
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addJourney(@RequestBody Journey j) {
        System.out.println("Post add journey");
        return null;
//        JourneyService.addJourney(j);
//        return ResponseEntity.created(new URI("" + j.getId())).build();
    }
}
