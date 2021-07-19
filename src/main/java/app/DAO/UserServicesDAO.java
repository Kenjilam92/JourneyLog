package app.DAO;
import app.models.*;
import java.util.*;

public interface UserServicesDAO {
    public List<User> getAllUser();
    public User getUserById( int x );
    public User getUserByEmailAndPassword(String email, String password);
    public boolean createUser (User x);
    public boolean deleteUser (User x);
    public boolean updateUser (User x);
}
