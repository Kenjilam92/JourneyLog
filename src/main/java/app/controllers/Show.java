package app.controllers;
<<<<<<< HEAD
import app.services.*;
import app.models.*;

import java.util.*;
=======
>>>>>>> origin/yuna

import app.models.Journey;
import app.models.Location;
import app.models.User;
import app.services.JourneyServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("show")

public class Show {

<<<<<<< HEAD
        private UserServices userService = UserServices.getServices();
        private JourneyServices journeyService;

        @GetMapping(path="users",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity showAllUser() {

                System.out.println("All Users");

                User u = new User("kenji","lam","kenjilam@123.com","123456");
                return ResponseEntity.ok(u);
        }

        @GetMapping(path="users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity showUserById(@PathVariable Integer id) {
                userService.getUserById( id );
                System.out.println(id);
=======
//      private UserServices userService = UserService.getService();
        private JourneyServices journeyService;

        // Show All Users
        @GetMapping(path="users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public List<User> getAllUser() {

                System.out.println("All Users");

                // Test JSON print out user with dummy data
                User u =  new User("Yuna", "Han", "y@y.com", "1234");
                System.out.println(u);

//                List<User> users = userServices.getAllUser();
                return (List<User>) ResponseEntity.notFound().build();
        }

        // Show User by Id
        @GetMapping(path="users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<User> getUserById() {
//                userService.getUserById(userId);

                // Test JSON print out user with dummy data
                User u =  new User("Yuna", "Han", "y@y.com", "1234");
                System.out.println(u);

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
>>>>>>> origin/yuna
                return ResponseEntity.notFound().build();
        }
}
