package controllers;

//import models.*;
import services.JourneyService;
import services.UserService;
import services.*;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class Show {

        private UserService userService;
        private JourneyService journeyService;

        // Show All Users
        @GetMapping(path="/users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public ResponseEntity showAllUser() {
                System.out.println("All Users");
                return ResponseEntity.notFound().build();
        }

//        // Show User by Id
//        @GetMapping(path="users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
//        public ResponseEntity showUserById(@PathVariable Integer id) {
//
//                System.out.println(id);
//                return ResponseEntity.notFound().build();
//        }
//
//        // Show All Locations
//        @GetMapping(path="locations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public ResponseEntity showAllLocation() {
//                System.out.println("All Locations");
//                return ResponseEntity.notFound().build();
//        }
//
//        // Show Location by Id
//        @GetMapping(path="locations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public ResponseEntity showLocationById(@PathVariable Integer id) {
//
//                System.out.println(id);
//                return ResponseEntity.notFound().build();
//        }
//
//        // Show All Journeys
//        @GetMapping(path="journeys", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public ResponseEntity showAllJourney() {
//
//                System.out.println("All Journeys");
//                return ResponseEntity.notFound().build();
//        }
//
//        // Show Journey by Id
//        @GetMapping(path="journeys/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public ResponseEntity showJourneyById(@PathVariable Integer id) {
//
//                System.out.println(id);
//                return ResponseEntity.notFound().build();
//        }
}
