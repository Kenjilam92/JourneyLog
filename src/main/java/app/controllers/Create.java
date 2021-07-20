package app.controllers;
import app.models.Journey;
import app.models.Location;
import app.models.User;


import app.services.JourneyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("create")
public class Create {

    @Autowired
    public void UserService() {

    }


    @PostMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean createUser(@RequestBody User x) throws URISyntaxException {
        System.out.println("Post register user");
        return true;
//        UserServices.createUser(x);
//        return ResponseEntity.created(new URI("" + u.getId())).build();
    }

    @PostMapping(path="locations", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean createLocation(@RequestBody Location x) throws URISyntaxException {
        System.out.println("Post add location");
        return true;
//        UserServices.createLocation(x);
//        return ResponseEntity.created(new URI("" + l.getId())).build();
    }

    @PostMapping(path="journeys", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean createJourney(@RequestBody Journey x) throws URISyntaxException {
        System.out.println("Post add journey");
        return true;
//        JourneyServices.createJourney(x);
//        return ResponseEntity.created(new URI("" + x.getId())).build();
    }

}
