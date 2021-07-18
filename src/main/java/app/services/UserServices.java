package app.services;
import app.DAO.*;
import app.models.*;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserServices implements UserServicesDAO {

    private SessionFactory sessionFactory;
    private static UserServices instance = new UserServices();
    private JourneyServices jourServ = JourneyServices.getServices();

    private UserServices(){
        super();
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
            users = session.createCriteria(User.class).list();
            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from USERS_APP where email=:email and password= :password");
        query.setParameter("email", email);
        query.setParameter("password",password);
        user = (User) query.uniqueResult();

        return user;
    }

    public boolean createUser(User x) {
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
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
