package app.controllers;
import app.services.*;
import app.models.*;

import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("show")
public class Show {

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
