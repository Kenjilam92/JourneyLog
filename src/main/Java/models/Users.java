package src.main.Java.models;

public class Users {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Location addressBook;

    public Users(int userId, String firstName, String lastName, String email, String password, Location addressBook){
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.addressBook = addressBook;
    }

    public Users(){
        //constructor stub
    }

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "User ID: " + userId +
                ", First Name: " + firstName + '\'' +
                ", Last Name: " + lastName + '\'' +
                ", Email: " + email + '\'' +
                ", PW: " + password + '\'' +
                ", Address Book: " + addressBook +
                '}';
    }

}
