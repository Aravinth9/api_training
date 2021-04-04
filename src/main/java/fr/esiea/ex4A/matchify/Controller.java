package fr.esiea.ex4A.matchify;

import fr.esiea.ex4A.matchify.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class Controller {

    @Autowired
    private AgifyService agifyService;

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object> responseEntity (@RequestBody UserInfo userInfo) throws IOException {
            AgifyResponse agifyResponse = this.agifyService.getUserAge(userInfo.getUserName(),userInfo.getUserCountry());
            this.agifyService.addNewUser(userInfo,agifyResponse);
            this.agifyService.get(userInfo.getUserName());
            return ResponseEntity.status(HttpStatus.CREATED).body(userInfo);
    }
    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserInfo> getMatchingUsers(@RequestParam(name = "userName", required = true) String name, @RequestParam(name = "userCountry", required = true) String country) {
        List<UserInfo> userList = this.agifyService.matchUser(name, country);
        return userList;
    }
}
