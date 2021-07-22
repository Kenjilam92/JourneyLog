package app.controllers;
import app.models.*;
import app.services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("create")

public class Create {

    private UserServices userServices = UserServices.getServices() ;
    private LocationServices locationServices = LocationServices.getServices() ;
    private JourneyServices journeyServices = JourneyServices.getServices() ;

    @PostMapping(path="users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> newUser) throws URISyntaxException {

        System.out.println("this is running");

        String email = newUser.get("email");
        String password = newUser.get("password");
        String firstName = newUser.get("firstName");
        String lastName = newUser.get("lastName");
        User register = new User(firstName, lastName, email, password);
        System.out.println(register);
        if( userServices.createUser(register) ){
            return new ResponseEntity("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
        }
        return new ResponseEntity("{ \"connected\" : true, \"status\" : \"failure\" }", HttpStatus.OK);

    }

    @PostMapping(path="locations", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createLocation( @RequestBody Map<String, Object> newLocation ) throws URISyntaxException {
        int streetNumber = (int) newLocation.get("streetNumber");
        String streetName = (String) newLocation.get("streetName");
        String city = (String) newLocation.get("city");
        String state = (String) newLocation.get("state");
        String zipcode = (String) newLocation.get("zipcode");
        Location lo = new Location(streetNumber,streetName,city,state,zipcode);
        if( locationServices.createLocation(lo) ){
            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
        }
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"failure\" }", HttpStatus.OK);

    }

    @PostMapping(path="journeys", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createJourney(@RequestBody Map<String, Object> newJourney) throws URISyntaxException {
        int creatorId = (int) newJourney.get("userId");
        int length = (int) newJourney.get("length");
        int time = (int) newJourney.get("time");

        User creator = userServices.getUserById(creatorId);
        if ( creator == null ){
            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"failure\" }", HttpStatus.OK);
        }

        List<Location> stopPoints = (List<Location>) newJourney.get("stopPoints");
        if ( stopPoints.size() < 2){
            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"failure\" }", HttpStatus.OK);
        }

        for ( int i =0 ; i < stopPoints.size() ; i++ ){
            Location check = locationServices.checkExist( stopPoints.get(i) );
            if ( check == null ){
                locationServices.createLocation( stopPoints.get(i) );
                check = locationServices.checkExist( stopPoints.get(i) );
            }
            stopPoints.set( i, check );
        }
        Journey j = new Journey( creator, time,length,stopPoints );
        if (journeyServices.createJourney( j )){
            return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"success\" }", HttpStatus.OK);
        }
        return new ResponseEntity<>("{ \"connected\" : true, \"status\" : \"false\" }", HttpStatus.OK);

    }

}
