package controller;

import models.Location;
import models.User;

public class Delete {
	private UserService userService;
	private JourneyService journeyService;
	
    public void deleteUser() {
    	userService.removeUser();
    }

    public void deleteLocation() {
    	userService.removeLocation();
    }

    public void deleteJourney() {
    	userService.removeJourney();
    }
}
