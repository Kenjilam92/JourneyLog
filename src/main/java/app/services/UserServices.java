package app.services;
import app.DAO.*;
import app.models.*;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserServices implements UserServicesDAO {
    private static final Logger LOGGER = Logger.getLogger(UserServices.class.getName());

    private SessionFactory sessionFactory;
    private static UserServices instance = new UserServices();
    private JourneyServices jourServ = JourneyServices.getServices();

    private UserServices(){
        super();
        LOGGER.debug("Initializing User Services");
        final Configuration config = new Configuration().configure();
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    };

    public static UserServices getServices(){
        return instance;
    }


    public List<User> getAllUser() {
        List<User> users = null;
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            users = session.createCriteria(User.class).setFetchMode("journeyLog",FetchMode.EAGER).setFetchMode("addressBook",FetchMode.EAGER).list();
            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.debug("Exception in getAllUser:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
        }
        return users;
    }

    public User getUserById( int x ) {
        User user = null;
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            user = (User) session.get(User.class, x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            LOGGER.debug("Exception in getUserById:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
        }
        return user;
    }

    public User getUserByEmailAndPassword(String email, String password) {

        User user = null;
        try {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM User WHERE EMAIL= :em and PASSWORD= :pw");
            query.setParameter("em", email);
            query.setParameter("pw", password);

            List result = query.list();
            session.close();
            user = result.size() == 0 ? null : (User) result.stream().findFirst().orElse(null);
        }
        catch (Exception e){
            LOGGER.debug("Exception in getUserByEmailAndPassword:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
        }
        return user;
    }

    public boolean createUser(User x) {
        if( getUserByEmailAndPassword( x.getEmail(), x.getPassword()) != null ){
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
            LOGGER.debug("Exception in createUser:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
            return false;
        }
        return true;
    }

    public boolean deleteUser(User x) {
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List<Journey> JourneyLog = x.getJourneysLog();
            for ( Journey j: JourneyLog){ jourServ.deleteJourney(j); }

            session.delete(x);

            tx.commit();
            session.close();
        }
        catch (Exception e){
            LOGGER.debug("Exception in deleteUser:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
            return false;
        }
        return true;
    }

    public boolean updateUser(User x) {
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(x);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            LOGGER.debug("Exception in updateUser:");
            StackTraceElement[] trace = e.getStackTrace();
            for(int i = 0; i < trace.length; i++)
                LOGGER.debug(trace[i]);
            return false;
        }
        return true;
    }
}
