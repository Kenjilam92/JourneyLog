package app.services;

import app.DAO.LocationServicesDAO;
import app.models.*;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LocationServices implements LocationServicesDAO {
    private static final Logger LOGGER = Logger.getLogger(LocationServices.class.getName());

    private SessionFactory sessionFactory;
    private static LocationServices instance = new LocationServices();

    private LocationServices(){
        super();
        LOGGER.debug("Initializing Location Services");
        final Configuration config = new Configuration().configure();
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    };

    public static LocationServices getServices(){
        return instance;
    }


    public List<Location> getAllLocations() {
        List<Location> locations = null;
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            locations = session.createCriteria(Location.class).list();
            tx.commit();
            session.close();
        }catch (Exception e){
            LOGGER.debug("Exception in getAllLocations:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
        }
        return locations;
    }

    public Location getLocationById(int x) {
        Location location = null;
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            location = (Location) session.get(Location.class, x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            LOGGER.debug("Exception in getLocationById:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
        }
        return location;
    }

    public Location checkExist(Location x) {
        Location lo = null;
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Location " +
                    "where street_numbers=:streetNumber and" +
                    " street_name=:streetName and" +
                    " city=:city and" +
                    " state=:state and" +
                    " zipcode=:zipcode";
            Query query = session.createQuery(queryString);
            query.setParameter("streetNumber", x.getStreetNumber());
            query.setParameter("streetName", x.getStreetName());
            query.setParameter("city", x.getCity());
            query.setParameter("state", x.getState());
            query.setParameter("zipcode", x.getZipcode());
            lo = (Location) query.list().stream().findFirst().orElse(null);
        }
        catch (Exception e){
            LOGGER.debug("Exception in checkExist:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
        }
        return lo;
    }

    public boolean createLocation(Location x) {
        if(checkExist(x) != null) {
            return false;
        }
        else {
            try {
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                session.save(x);
                tx.commit();
                session.close();
            } catch (Exception e) {
                LOGGER.debug("Exception in createLocation:");
                StackTraceElement[] trace = e.getStackTrace();
                for(int i = 0; i < trace.length; i++)
                    LOGGER.debug(trace[i]);
                return false;
            }
            return true;
        }
    }

    public boolean deleteLocation(Location x) {
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            LOGGER.debug("Exception in deleteLocation:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
            return false;
        }
        return true;
    }

    public boolean updateLocation(Location x) {
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            LOGGER.debug("Exception in updateLocation:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
            return false;
        }
        return true;
    }
}
