package app.controllers;
import app.models.*;
import java.util.*;

import app.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class Login {
    private UserServices userServices = UserServices.getServices();

    @PostMapping(path="user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login (@RequestBody Map<String,String> loginData){
        String email = loginData.get("email");
        String password = loginData.get("password");

        User selected = userServices.getUserByEmailAndPassword(email,password);

        return selected != null ?
                selected.toJsonDetails()
                :
                "{ \"connected\" : true, \"status\" : \"false\" }";
    }

}
