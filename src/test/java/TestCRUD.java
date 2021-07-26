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

//	@BeforeAll
//	void greeting() {
//		System.out.println("Begin testing! ");
//	}
//
//	@BeforeEach
//	void border() {
//		System.out.println("*******************");
//	}

    @Test
    @Order(1)
    void createUser() {
        User u = new User("john", "david", "john@gmail.com", "1234");
        assertEquals(uServ.createUser(u), true);
    }

    @Test
    @Order(2)
    void uniqueEmail() {
        User u = new User("john", "david", "john@gmail.com", "1234");
        assertEquals(uServ.createUser(u), false);
    }

    @Test
    @Order(3)
    void updateUser() {
        User select = uServ.getUserByEmailAndPassword("john@gmail.com", "1234");

        select.setFirstName("John");
        select.setLastName("Doe");
//		System.out.println(select);
        assertEquals(uServ.updateUser(select), true);
    }

    @Test
    @Order(4)
    void createLocation1() {
        Location u = new Location(148, "Stable Rd", "Gilmer", "TX", "75645");
        assertEquals(locServ.createLocation(u), true);
    }

    @Test
    @Order(4)
    void createLocation2() {
        Location u = new Location(8525, "Garland Rd", "Dallas", "TX", "75218");
        assertEquals(locServ.createLocation(u), true);
    }

    @Test
    @Order(5)
    void updateLocation1() {
        Location select = locServ.getLocationById(1);

        select.setStreetNumber(149);

//		System.out.println(select);
        assertEquals(locServ.updateLocation(select), true);
    }

    @Test
    @Order(6)
    void createJourney() {
        Journey u = new Journey(user1, 45, 56, Location);
        assertEquals(jourServ.createJourney(u), true);
    }

    @Test
    @Order(7)
    void updateJourney() {
        Journey select = jourServ.getJourneyById(1);

        select.setStopPoints(List<Location>);
//		System.out.println(select);
        assertEquals(jourServ.updateJourney(select), true);
    }

    @Test
    @Order(8)
    void deleteJourney() {
        Journey u = new Journey(user1, 45, 56, Location);
        assertEquals(jourServ.deleteJourney(u), true);
    }

    @Test
    @Order(9)
    void deleteLocation1() {
        Location u = new Location(149, "Stable Rd", "Gilmer", "TX", "75645");
        assertEquals(locServ.deleteLocation(u), true);
    }

    @Test
    @Order(10)
    void deleteLocation2() {
        Location u = new Location(8525, "Garland Rd", "Dallas", "TX", "75218");
        assertEquals(locServ.deleteLocation(u), true);
    }

    @Test
    @Order(11)
    void deleteUser() {
        User u = new User("John", "Doe", "john@gmail.com", "1234");
        assertEquals(uServ.deleteUser(u), true);
    }

}