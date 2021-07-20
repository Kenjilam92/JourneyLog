package app.models;

import javax.persistence.*;

@Entity
@Table(name="Locations")
public class Location {
    @Id
    @SequenceGenerator(name="locationSeq", sequenceName = "hibernate_sequence_location", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSeq")
    @Column( name="LOCATION_ID")
    private int locationId;
    @Column( name="STREET_NUMBERS")
    private int streetNumber;
    @Column( name="STREET_NAME")
    private String streetName;
    @Column( name="CITY")
    private String city;
    @Column( name="STATE")
    private String state;
    @Column( name="ZIPCODE")
    // Kenji changed zipcode to String because some zipcode begin with 0. Ex: 00501
    private String zipcode;

    // we don't need location id for constructor because hibernate will help us generate one unique id
    public Location(int streetNumber, String streetName, String city, String state, String zipcode) {
        super();
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Location(){
        //constructor stub
    }
    public int getLocationId() {
        return locationId;
    }
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    public int getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    // Action Needed: Missing one " mark for each value.
    // toJson
    public String toString() {
        return "{\n\"Location ID\": " + locationId +
                ",\n\"Street Number\": " + streetNumber +
                ",\n\"Street Name\": " + "\"" + streetName + "\"" +
                ",\n\"City\": " + "\"" + city + "\"" +
                ",\n\"State\": " + "\"" + state + "\"" +
                ",\n\"Zipcode\": " + "\"" + zipcode + "\"\n}";

    }

}