package controller;

import models.Location;
import models.User;

public class Update {
	private UserService userService;
	private JourneyService journeyService;
	
	public void updateUser() {
		userService.updateUser();
	}
	
	public void updateLocation() {
		userService.updateLocation();
	}

	public void updateJourney() {
		journeyService.updateJourney();
	}
}
