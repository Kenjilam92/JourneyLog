package app.controllers;
import app.models.Journey;
import app.models.Location;
import app.models.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/create")

public class Create {

//    @Autowired
//    public void UserService() {
//
//    }

    @PostMapping(path="/users", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean createUser(@RequestBody User x) throws URISyntaxException {
//        boolean user = UsrSvcs.createUser(x);
        System.out.println("Post create user");
        return true;
//        return ResponseEntity.created(new URI("" + x.getUserId())).build();
    }

    @PostMapping(path="/locations", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean createLocation(@RequestBody Location x) throws URISyntaxException {
        System.out.println("Post create location");
        return true;
//        UserServices.createLocation(x);
//        return ResponseEntity.created(new URI("" + l.getId())).build();
    }

    @PostMapping(path="/journeys", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean createJourney(@RequestBody Journey x) throws URISyntaxException {
        System.out.println("Post create journey");
        return true;
//        JourneyServices.createJourney(x);
//        return ResponseEntity.created(new URI("" + x.getId())).build();

    }

}
