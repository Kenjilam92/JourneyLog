package app.controllers;
import app.models.Journey;
import app.models.Location;
import app.models.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("create")

public class Create {

//    @Autowired
//    public void UserService() {
//
//    }

    @PostMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser() throws URISyntaxException {
        System.out.println("Post create user");
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        return ResponseEntity.created(new URI("" + x.getUserId())).build();
    }

    @PostMapping(path="locations", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createLocation() throws URISyntaxException {
        System.out.println("Post create location");
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        UserServices.createLocation(x);
//        return ResponseEntity.created(new URI("" + l.getId())).build();
    }

    @PostMapping(path="journeys", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createJourney() throws URISyntaxException {
        System.out.println("Post create journey");
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
//        JourneyServices.createJourney(x);
//        return ResponseEntity.created(new URI("" + x.getId())).build();

    }

}
