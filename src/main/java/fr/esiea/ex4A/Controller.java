package fr.esiea.ex4A;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class Controller {


    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    UserInfo Creation(@RequestParam(name = "name", required = false) String name,@RequestParam(name = "caca", required = false) String caca ) {
        //UserInfo userInfo = new UserInfo(name, caca);
        //System.out.println((userInfo));
        //return new UserInfo("ij","ij","ij","ij", "userCountry");
        // return body;
        //return new UserInfo("ziaj", "ioji");
        return new UserInfo("ij","ij","ij","ij","ij","ij", java.util.Optional.of(15));
    }

    @PostMapping(path = "/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    void inscription (@RequestBody UserInfo userInfo){
    System.out.println(userInfo.getUserCountry());
    }

    /*
    @GetMapping
    List<match> matches(){
        return List.of(
            new match("eokp","fei"),
            new match("iopzjda", "iojoi")
        );
  }
  */
}
