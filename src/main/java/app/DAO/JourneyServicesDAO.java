package app.DAO;
import app.models.*;
import java.util.*;

public interface JourneyServicesDAO {
    public Journey getJourneyById ( int x);
    public List<Journey> getAllJourneys ();
    public List<Journey> getAllJourneysByUser ( User x );
    public boolean createJourney ( Journey x );
    public boolean deleteJourney ( Journey x );
    public boolean showAllJourneysByUser (User x);

}
