package fr.esiea.ex4A;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class Controller {

    @Autowired
    private AgifyService agifyService;

    /*
        @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
        UserInfo Creation(@RequestParam(name = "name", required = false) String name,@RequestParam(name = "caca", required = false) String caca ) {
            //UserInfo userInfo = new UserInfo(name, caca);
            //System.out.println((userInfo));
            //return new UserInfo("ij","ij","ij","ij", "userCountry");
            // return body;
            //return new UserInfo("ziaj", "ioji");
            return new UserInfo("ij","ij","ij","ij","ij","ij", java.util.Optional.of(15));
        }


     */
    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> match(@RequestParam(name = "userName") String userName, @RequestParam(name = "userCountry") String userCountry) {
        UserInfo userinfo = new UserInfo("son nom","son nom","son nom","son nom","son nom","son nom", java.util.Optional.of(14));
        return ResponseEntity.status(HttpStatus.OK).body(userinfo);
    }
    @PostMapping(path = "/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    void inscription (@RequestBody UserInfo userInfo){
        agifyService.add(userInfo);
        System.out.println(agifyService.getAll().get(0));
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
