package src.main.Java.models;

public class Location {

    private int locationId;
    private int streetNumber;
    private String streetName;
    private String city;
    private String state;
    private int zipcode;

    public Location(int locationId, int streetNumber, String streetName, String city, String state, int zipcode) {
        super();
        this.locationId = locationId;
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
    public int getZipcode() {
        return zipcode;
    }
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "location ID: " + locationId +
                ", Street Number: " + streetNumber +
                ", Street Name: " + streetName + '\'' +
                ", City: " + city + '\'' +
                ", State: " + state + '\'' +
                ", Zipcode: " + zipcode +
                '}';
    }

}