package app.controllers;
import app.models.Journey;
import app.models.User;



import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

//@RestController
//@RequestMapping("create")
public class Create {

//    @Autowired
//    public void UserService() {
//
//    }


    @PostMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody User u) throws URISyntaxException {
        System.out.println("Post register user");
        return null;
//        UserService.register(u);
//        return ResponseEntity.created(new URI("" + u.getId())).build();
    }

    @PostMapping(path="locations", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLocation(@RequestBody User l) throws URISyntaxException {
        System.out.println("Post add location");
        return null;
//        UserService.addLocation(l);
//        return ResponseEntity.created(new URI("" + l.getId())).build();
    }

    @PostMapping(path="journeys", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addJourney(@RequestBody Journey j) throws URISyntaxException {
        System.out.println("Post add journey");
        return null;
//        JourneyService.addJourney(j);
//        return ResponseEntity.created(new URI("" + j.getId())).build();
    }

}
