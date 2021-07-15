package src.main.Java.models;

public class Journey {

    private int journeyId;
    private Users creator;
    private int time;
    private int length;

    public Journey(int journeyId, Users creator, int time, int length){
        super();
        this.journeyId = journeyId;
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
    public Users getCreator() {
        return creator;
    }
    public void setCreator(Users creator) {
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
    public String toString() {
        return "Journey ID: " + journeyId +
                ", User creator: " + creator +
                ", Travel time: " + time +
                ", Distance: " + length +
                '}';
    }

}
