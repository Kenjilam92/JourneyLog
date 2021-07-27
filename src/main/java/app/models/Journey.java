package app.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="JOURNEYS")
public class Journey {
    @Id
    @SequenceGenerator( name = "journeySeq", sequenceName = "hibernate_sequence_journey", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "journeySeq")
    @Column(name = "JOURNEY_ID")
    private int journeyId;
    @ManyToOne ( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn ( name = "CREATOR_ID", referencedColumnName = "USER_ID", columnDefinition = "INT")
    private User creator;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name="JOURNEY_LOCATION",
            joinColumns = @JoinColumn(name="JOURNEY_ID", referencedColumnName =  "JOURNEY_ID", columnDefinition = "INT"),
            inverseJoinColumns = @JoinColumn(name="LOCATION_ID", referencedColumnName="LOCATION_ID", columnDefinition = "INT")
    )
    private List<Location> stopPoints;
    @Column(name="TIME")
    private int time;
    @Column(name="LENGTH")
    private int length;

    //we don't need to add id in the constructor because hibernate will auto generate an unique id
    public Journey(User creator, int time, int length, List<Location> stopPoints ){
        super();
        this.creator = creator;
        this.time = time;
        this.length = length;
        this.stopPoints = stopPoints;
    }

    public Journey(){
        //constructor stub
    }

    public int getJourneyId() {
        return journeyId;
    }
    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }
    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public void setStopPoints( List<Location> stopPoints ){
        this.stopPoints = stopPoints;
    }

    public List<Location> getStopPoints(){
        return this.stopPoints;
    }

    @Override
    // Action Needed: Missing one " mark for each value.
    // toJson
    public String toString() {
        StringBuffer addressJson = new StringBuffer();
        addressJson.append("[");
        stopPoints.stream().forEach(a-> addressJson.append(a.toString() + ", "));
        if (stopPoints.size()>0) addressJson.setLength(addressJson.length()-1);
        addressJson.append("]");

        return "{\n\"journeyId\": " + journeyId +
                ",\n\"creatorId\": " +  creator.getUserId() +
                ",\n\"stopPoints\" : " + addressJson.toString() +
                ",\n\"time\": " + time +
                ",\n\"length\": " + length + "\n}";
    }

}
