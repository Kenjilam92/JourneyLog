package app.services;

import app.DAO.LocationServicesDAO;
import app.models.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LocationServices implements LocationServicesDAO {

    private SessionFactory sessionFactory;
    private static LocationServices instance = new LocationServices();

    private LocationServices(){
        super();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return location;
    }

    public Location checkExist(Location x) {
        Location lo = null;
        Session session = sessionFactory.openSession();
        String queryString = "from LOCATIONS " +
                             "where street_numbers=:streetNumber and" +
                             " street_name=:streetName and" +
                             " city=:city and" +
                             " state=:state and" +
                             " zipcode=:zipcode";
        Query query = session.createQuery( queryString );
        query.setParameter("streetNumber", x.getStreetNumber() );
        query.setParameter("streetName", x.getStreetName() );
        query.setParameter("city", x.getCity() );
        query.setParameter("state", x.getState() );
        query.setParameter("zipcode", x.getZipcode() );
        lo = (Location) query.uniqueResult();
        return lo;
    }

    public boolean createLocation(Location x) {
        if(checkExist(x) != null) {
            return false;
        }
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
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
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
