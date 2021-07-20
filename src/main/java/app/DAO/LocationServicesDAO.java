package app.DAO;

import app.models.Location;

import java.util.List;

public interface LocationServicesDAO {
    public List<Location> getAllLocations();
    public Location getLocationById(int x);
    public boolean createLocation( Location x );
    public boolean deleteLocation( Location x );
    public boolean updateLocation( Location x );
}
