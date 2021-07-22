package app.controllers;
import app.models.*;
import app.services.*;

import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")

public class Show {

        private UserServices userServices = UserServices.getServices();
        private JourneyServices journeyServices = JourneyServices.getServices();
        private LocationServices locationServices = LocationServices.getServices();

        // Show All Users
        @GetMapping(path="users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public List<User> getAllUser() {
                List<User> users = userServices.getAllUser();

                return users;
        }

        // Show User by Id
        @GetMapping(path="users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity getUserById(@PathVariable Integer id) {

                User user = userServices.getUserById(id);

                return ResponseEntity.ok(user);
        }

        // Show All Locations
        @GetMapping(path="locations", produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity getAllLocations() {
//                System.out.println("All Locations");

                List<Location> lo = locationServices.getAllLocations();
                return ResponseEntity.ok(lo);
        }

        // Show Location by Id
        @GetMapping(path="locations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity getLocationById(@PathVariable int x) {

//                System.out.println(x);

                Location lo = locationServices.getLocationById(x);
                return ResponseEntity.ok(x);
        }

        // Show All Journeys
        @GetMapping(path="journeys", produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity getAllJourneys() {

//                System.out.println("All Journeys");
                List<Journey> journeys = journeyServices.getAllJourneys();
                return ResponseEntity.ok(journeys);
        }

        // Show Journey by Id
        @GetMapping(path="journeys/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity getJourneyById(@PathVariable int x) {

//                System.out.println(x);
                Journey j = journeyServices.getJourneyById(x);
                return ResponseEntity.ok(j);
        }
}
