package app.controllers;

import app.models.Journey;
import app.models.Location;
import app.models.User;
import app.services.JourneyServices;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/show")
public class Show {

//        private UserServices userService;
        private JourneyServices journeyService;

        // Show All Users
        @GetMapping(path="/users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public List<User> getAllUsers() {

                System.out.println("All Users");
                return (List<User>) ResponseEntity.notFound().build();
        }

        // Show User by Id
        @GetMapping(path="users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<User> getUserById(@PathVariable int x) {

                System.out.println(x);
                return ResponseEntity.notFound().build();
        }

        // Show All Locations
        @GetMapping(path="locations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public List<Location> getAllLocations() {
                System.out.println("All Locations");
                return (List<Location>) ResponseEntity.notFound().build();
        }

        // Show Location by Id
        @GetMapping(path="locations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public ResponseEntity<Location> getLocationById(@PathVariable int x) {

                System.out.println(x);
                return ResponseEntity.notFound().build();
        }

        // Show All Journeys
        @GetMapping(path="journeys", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public List<Journey> getAllJourneys() {

                System.out.println("All Journeys");
                return (List<Journey>) ResponseEntity.notFound().build();
        }

        // Show Journey by Id
        @GetMapping(path="journeys/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public ResponseEntity<Journey> getJourneyById(@PathVariable int x) {

                System.out.println(x);
                return ResponseEntity.notFound().build();
        }
}
