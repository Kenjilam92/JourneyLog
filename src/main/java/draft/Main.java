package draft;

import services.*;

public class Main {
    public static void main ( String[] vararg){
        String email = "kenji@gmail.com";
        String password = "1234";
        String firstName = "Kenji";
        String lastName ="Lam";
        UserServices uServ = UserServices.getServices();
        uServ.register(email,password,firstName,lastName);
    }
}
