import app.services.*;
import app.models.*;

import java.util.*;

public class TestCRUD {
//    public UserServices uServ = UserServices.getServices();
    public LocationServices locServ = LocationServices.getServices();
    public JourneyServices jourServ = JourneyServices.getServices();

    User user1 = new User("Kenji","Lam","kenji@revature.com","123456");
    User user2 = new User("John","Lemon","John@revature.com","456789");
    User user3 = new User("Nancy","Robinson","Nancy@revatur.com","456123");

    Location loc1 = new Location(4556, "Street A", "City A", "VA", "22116");
    Location loc2 = new Location( 113, "Street B","City B", "CA","00648" );
    Location loc3 = new Location( 789, "Street C", "City C", "TX", "55647");

    ArrayList<Location> listLoc1 = new ArrayList<Location>();
    List<Location> listLoc2 = new ArrayList<Location>();
    List<Location> listLoc3 = new ArrayList<Location>();

    public TestCRUD(){
        listLoc1.add(loc1);
        listLoc1.add(loc2);

        listLoc2.add(loc2);
        listLoc2.add(loc3);

        listLoc3.add(loc3);
        listLoc3.add(loc1);



    }

}
