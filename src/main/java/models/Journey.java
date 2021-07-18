package models;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Journeys")
public class Journey {
    @Id
    @SequenceGenerator( name = "journeySeq", sequenceName = "hibernate_sequence_journey", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "journeySeq")
    @Column(name = "JOURNEY_ID")
    private int journeyId;
    @ManyToOne ( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn ( name = "CREATOR_ID", referencedColumnName = "USER_ID", columnDefinition = "INT")
    private User creator;
    @Column(name="TIME")
    private int time;
    @Column(name="LENGTH")
    private int length;

    //we don't need to add id in the constructor because hibernate will auto generate an unique id
    public Journey(User creator, int time, int length){
        super();
        this.creator = creator;
        this.time = time;
        this. length = length;
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

    @Override
    // Action Needed: Missing one " mark for each value.
    // toJson
    public String toString() {
        return "{\n\"Journey ID\": " + journeyId +
                ",\n\"User creator\": " + "\"" + creator + "\"" +
                ",\n\"Travel time\": " + time +
                ",\n\"Distance\": " + length + "\n}";
    }

}
