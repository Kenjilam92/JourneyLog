package app.DAO;

import app.models.User;

import java.util.List;

public interface UserServicesDAO {
    public List<User> getAllUsers();
    public User getUserById( int x );
    public User getUserByEmailAndPassword(String email, String password);
    public boolean createUser (User x);
    public boolean deleteUser (User x);
    public boolean updateUser (User x);
}
