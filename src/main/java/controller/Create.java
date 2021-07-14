package controller;

import models.Location;
import models.User;

public class User {
	private UserService userService;
	private JourneyService journeyService;
	
	public void addUser() {
		userService.addUser();
	}
	
	public void addLocation() {
		userService.addLocation();
	}

	public void addJourney() {
		journeyService.addJourney();
	}
}
