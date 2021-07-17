package services;
import models.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UserServices {

    private SessionFactory sessionFactory;
    private static UserServices instance = new UserServices();

    private UserServices(){
        super();
        final Configuration config = new Configuration().configure();
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    };

    public static UserServices getServices(){
        return instance;
    }

    // Implementation


    /* Register User */
    public void register(String eM, String pw, String fN, String lN) {
        User newUser = new User(fN,lN,eM,pw);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(newUser);
        tx.commit();
        session.close();
    }

    /* Login User */
    public void login() {

    }

    /* Show User by ID */
    public void showUserById() {

    }

    /* Update User */
    public void updateUser() {
        // Update Name

        // Change Password

        // Change Email
    }

    /* Add Location */
    public void addLocation(User l) {

    }

    /* Remove Location */
    public void removeLocation() {

    }
}
