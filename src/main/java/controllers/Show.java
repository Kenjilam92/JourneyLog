package controllers;
import models.*;
import services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Show {

        private UserService userService;
        private JourneyService journeyService;

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public void showAllUser(RequestParam(defaultValue = "false")) {
                System.out.println("All Users");
        }

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public void showAllLocation() {
                System.out.println("All Locations");
        }

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public void showAllJourney() {
                System.out.println("All Journeys");
        }

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public void showUserById() {
                userService.showUserById();
        }

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public void showLocationById() {
                System.out.println("Show location by Id");
//                userService.showLocationById();
        }

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public void showJourneyById() {
                System.out.println("Show journey by Id");
                journeyService.showJourneyById();
        }
}
