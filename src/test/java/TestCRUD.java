import app.services.*;
import app.models.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.core.annotation.Order;

import java.util.*;

public class TestCRUD {
    public UserServices uServ = UserServices.getServices();
    public LocationServices locServ = LocationServices.getServices();
    public JourneyServices jourServ = JourneyServices.getServices();

    User user1 = new User("Kenji", "Lam", "kenji@revature.com", "123456");
    User user2 = new User("John", "Lemon", "John@revature.com", "456789");
    User user3 = new User("Nancy", "Robinson", "Nancy@revatur.com", "456123");

    Location loc1 = new Location(4556, "Street A", "City A", "VA", "22116");
    Location loc2 = new Location(113, "Street B", "City B", "CA", "00648");
    Location loc3 = new Location(789, "Street C", "City C", "TX", "55647");

    ArrayList<Location> listLoc1 = new ArrayList<Location>();
    List<Location> listLoc2 = new ArrayList<Location>();
    List<Location> listLoc3 = new ArrayList<Location>();

    public TestCRUD() {
        listLoc1.add(loc1);
        listLoc1.add(loc2);

        listLoc2.add(loc2);
        listLoc2.add(loc3);

        listLoc3.add(loc3);
        listLoc3.add(loc1);

    }

    @Test
    @Order(1)
   public void createUser() {
        User u = new User("john", "david", "john@gmail.com", "1234");
        assertFalse(uServ.createUser(u));
    }

    @Test
    @Order(2)
   public void uniqueEmail() {
        User u = new User("john", "david", "john@gmail.com", "1234");
        assertTrue(uServ.createUser(u));
    }

    @Test
    @Order(3)
    public void updateUser() {
        User select = uServ.getUserByEmailAndPassword("john@gmail.com", "1234");

        select.setFirstName("John");
        select.setLastName("Doe");
//		System.out.println(select);
        assertTrue(uServ.updateUser(select));
    }

    @Test
    @Order(4)
    public void createLocation1() {
        Location u = new Location(148, "Stable Rd", "Gilmer", "TX", "75645");
        assertTrue(locServ.createLocation(u));
    }

    @Test
    @Order(5)
    public void createLocation2() {
        Location u = new Location(8525, "Garland Rd", "Dallas", "TX", "75218");
        assertTrue(locServ.createLocation(u));
    }

    @Test
    @Order(6)
    public void updateLocation1() {
        Location select = locServ.getLocationById(1);

        select.setStreetNumber(301);
        assertTrue(locServ.updateLocation(select));
    }

    @Test
    @Order(7)
    public void createJourney() {
        Journey u = new Journey(user1, 45, 56, listLoc1);
        assertTrue(jourServ.createJourney(u));
    }

    @Test
    @Order(8)
    public void updateJourney() {
        Journey select = jourServ.getJourneyById(1);

        select.setStopPoints(listLoc2);
        assertTrue(jourServ.updateJourney(select));
    }

    @Test
    @Order(9)
    public void deleteJourney() {
       Journey u = new Journey(user1, 45, 56, listLoc1);
        assertEquals(jourServ.deleteJourney(u), true);
    }

    @Test
    @Order(10)
    public void deleteLocation1() {
        Location u = new Location(148, "Stable Rd", "Gilmer", "TX", "75645");
        assertTrue(locServ.deleteLocation(locServ.checkExist(u)));
    }

    @Test
    @Order(11)
    public void deleteLocation2() {
        Location u = new Location(8525, "Garland Rd", "Dallas", "TX", "75218");
        assertTrue(locServ.deleteLocation(locServ.checkExist(u)));
    }

    @Test
    @Order(12)
    public void deleteUser() {
        User u = uServ.getUserByEmailAndPassword("john@gmail.com", "1234");
        assertTrue(uServ.deleteUser(u));
    }

}