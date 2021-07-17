package draft;

import app.services.UserServices;
import services.*;

public class Main {
    public static void main ( String[] vararg){
        String email = "kenji@gmail.com";
        String password = "1234";
        String firstName = "Ken";
        String lastName ="Lam";
        UserServices uServ = UserServices.getServices();
        uServ.register(email,password,firstName,lastName);
    }
}
