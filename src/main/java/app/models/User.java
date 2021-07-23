package app.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="USERS_APP")
public class User {
    // 7/15 - 8pm: added hibernate annotate
    //Id key to identify primary key
    @Id
    //this annotate bellow is create a sequence on Oracle database
    @SequenceGenerator(name="userSeq", sequenceName = "hibernate_sequence_user", allocationSize = 1)
    //this auto create a user ID for every new user
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(name="USER_ID")
    private int userId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;

    //this is ManyToMany annotation which help create a relationship table in SQL
    @ManyToMany
    @JoinTable( name="User_Location",
            joinColumns = @JoinColumn(name="USER_ID", referencedColumnName =  "USER_ID", columnDefinition = "INT"),
            inverseJoinColumns = @JoinColumn(name="LOCATION_ID", referencedColumnName="LOCATION_ID", columnDefinition = "INT")
    )
    //this should be in list because address book have more than one location
    private List<Location> addressBook;


    @OneToMany( mappedBy = "creator")
    private List<Journey> journeysLog;




    //We don't need to initiate address book when create a new user because User can have empty address book
    //We also don't need user id because hibernate will auto generate a unique id for us
    public User(String firstName, String lastName, String email, String password){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.addressBook = new ArrayList<Location>();
        this.journeysLog = new ArrayList<Journey>();
    }

    public User(){
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

    public List<Location> getAddressBook(){
        return addressBook;
    }
    public List<Journey> getJourneysLog(){
        return journeysLog;
    }
    @Override
    public String toString() {
        return "{\n\"userId\": " + userId +
                ",\n\"firstName\": " + "\"" + firstName + "\"" +
                ",\n\"lastName\": " + "\"" + lastName + "\"" +
                ",\n\"email\": " + "\"" + email + "\"" +
                ",\n\"password\": " + "\"" + password + "\"" +
                "\n}";
    }
    public String toJsonDetails() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\n\"userId\": " + userId +
                ",\n\"firstName\": " + "\"" + firstName + "\"" +
                ",\n\"lastName\": " + "\"" + lastName + "\"" +
                ",\n\"email\": " + "\"" + email + "\"" +
                ",\n\"password\": " + "\"" + password + "\"" +
                "\n"
        );

        json.append("\"addressBook\" : [" );
        addressBook.stream().forEach( l -> json.append( l.toString() + "," ) );
        if(addressBook.size()>0) json.setLength(json.length()-1);
        json.append("],");

        json.append("\"journeyLog\" : [");
        journeysLog.stream().forEach(j -> json.append( j.toString() + ",") );
        if(journeysLog.size() > 0) json.setLength(json.length()-1);
        json.append("]");

        json.append("}");
        return json.toString();
    }
}
