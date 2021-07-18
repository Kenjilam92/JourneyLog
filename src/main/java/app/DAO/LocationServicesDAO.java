package app.DAO;
import app.models.*;
import java.util.*;

public interface LocationServicesDAO {
    public List<Location> getAllLocations();
    public Location getLocationById(int x);
    public boolean createLocation( Location x );
    public boolean deleteLocation( Location x );
    public boolean updateLocation( Location x );
}
