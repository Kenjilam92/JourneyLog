package app.services;
import app.DAO.*;
import app.models.*;

import org.hibernate.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class JourneyServices implements JourneyServicesDAO {

    private SessionFactory sessionFactory;
    private static JourneyServices instance = new JourneyServices();

    private JourneyServices(){
        super();
        final Configuration config = new Configuration().configure();
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    };

    public static JourneyServices getServices(){
        return instance;
    }



    public List<Journey> getAllJourneys() {
        List<Journey> journeys = null;
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            journeys = session.createCriteria(Journey.class).list();
            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return journeys;
    }

    public Journey getJourneyById(int x) {
        Journey journey = null;
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            journey = (Journey) session.get(Journey.class, x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return journey;
    }

    public boolean createJourney(Journey x) {
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

    public boolean deleteJourney(Journey x) {
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

    public boolean updateJourney(Journey x) {
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
