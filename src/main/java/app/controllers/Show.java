package app.controllers;
//import models.*;
import app.services.JourneyServices;
import app.services.UserServices;
import app.services.*;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("show")
public class Show {

        private UserServices userService;
        private JourneyServices journeyService;

        @GetMapping(path="users",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity showAllUser() {

                System.out.println("All Users");
                return ResponseEntity.notFound().build();
        }

        @GetMapping(path="users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity showUserById(@PathVariable Integer id) {

                System.out.println(id);
                return ResponseEntity.notFound().build();
        }
//
//
//        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public void showAllLocation() {
//                System.out.println("All Locations");
//        }
//
//        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public void showAllJourney() {
//                System.out.println("All Journeys");
//        }
//
//        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public void showUserById() {
//                userService.showUserById();
//        }
//
//        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public void showLocationById() {
//                System.out.println("Show location by Id");
//                userService.showLocationById();
//        }
//
//        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//        public void showJourneyById() {
//                System.out.println("Show journey by Id");
//                journeyService.showJourneyById();
//        }
}
