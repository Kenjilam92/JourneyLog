package app.services;

import app.DAO.LocationServicesDAO;
import app.models.*;

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

    public boolean createLocation(Location x) {
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
