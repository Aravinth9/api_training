package fr.esiea.ex4A.matchify;

import fr.esiea.ex4A.matchify.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class Controller {

    @Autowired
    private AgifyService agifyService;

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> match(@RequestParam(name = "userName") String userName, @RequestParam(name = "userCountry") String userCountry) {
        int age = agifyService.getUser(userName).getUserAge();
        Sex userSexPref = agifyService.getUser(userName).getUserSexPref();
        List<UserInfo> usermatches = agifyService.getAll().stream()
            .filter(x -> !x.getUserName().equals(userName) &&
                x.getUserSex().equals(userSexPref) &&
                x.getUserAge() >= age - 4 &&
                x.getUserAge() <= age + 4)
            .collect(Collectors.toList());
        List<Match> listMatches = new ArrayList<>();
        for (UserInfo user : usermatches) {
            Match matches = new Match(user.getUserName(), user.getUserTweeter());
            listMatches.add(matches);
        }
        if (listMatches.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No matches found");
        } else {
            System.out.println(ResponseEntity.status(HttpStatus.FOUND).body(listMatches));
            return ResponseEntity.status(HttpStatus.OK).body(listMatches);
        }
    }
    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object> responseEntity (@RequestBody UserInfo userInfo) {
        if(agifyService.exists(userInfo)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        else {
            int age = agifyService.getUserAge(userInfo.getUserName(), userInfo.getUserCountry());
            UserInfo newUser = new UserInfo(userInfo , age);
            agifyService.add(newUser);
            System.out.println(agifyService.getAll());
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
    }
}
