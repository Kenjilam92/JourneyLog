package app.controllers;
import app.models.Journey;
import app.models.Location;
import app.models.User;
import app.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping(
        value = "create",
        method = RequestMethod.POST,
        consumes = "text/plain")

public class Create {

//    private UserServices user;
    private LocationServices location;
    private JourneyServices journey;

//    @Autowired
//    public void UserService() {
//        user = UserServices.getServices();
//    }
//
    @PostMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody String x) throws URISyntaxException {
//        boolean aSuccess = user.createUser(x);
        System.out.println(x);
        System.out.println("Post create user");
//        if (aSuccess = true) {
//            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"failed\" }", HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);

//        return ResponseEntity.created(new URI("" + x.getUserId())).build();
    }

    @PostMapping(path="locations", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createLocation(@RequestBody String x) throws URISyntaxException {
//        boolean aSuccess = location.createLocation(x);
        System.out.println(x);
        System.out.println("Post create location");
//        if (aSuccess = true) {
//            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"failed\" }", HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);

//        return ResponseEntity.created(new URI("" + l.getId())).build();
    }

    @PostMapping(path="journeys", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createJourney(@RequestBody String x) throws URISyntaxException {
//        boolean aSuccess = journey.createJourney(x);

        System.out.println(x);
        System.out.println("Post create journey");
//        if (aSuccess = true) {
//            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"failed\" }", HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        return ResponseEntity.created(new URI("" + x.getId())).build();

    }

}
