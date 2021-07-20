package app.DAO;

import app.models.Journey;

import java.util.List;

public interface JourneyServicesDAO {
    public List<Journey> getAllJourneys ();
    public Journey getJourneyById ( int x);
    public boolean createJourney ( Journey x );
    public boolean deleteJourney ( Journey x );
    public boolean updateJourney ( Journey x );

}
