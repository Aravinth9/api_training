package fr.esiea.ex4A.hello;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
class HelloController {

    private final HelloRepository helloRepository;

    HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    HelloData sayHello(@RequestParam(name = "name", required = false) String name) {
        final HelloData helloData;
        if (name == null || name.isBlank()) {
            helloData = helloRepository.randomHello();
        } else {
            helloData = helloRepository.getHelloFor(name);
        }
        return helloData;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>responseEntity(@RequestBody Map<String, String> body) {
        if(body.containsKey("userEmail")
            && body.containsKey("userName")
            && body.containsKey("userTweeter")
            && body.containsKey("userCountry")
            && body.containsKey("userSex")
            && body.containsKey("userSexPref")) {
            if(body.get("userSex").matches("^[OMF]$") && body.get("userSexPref").matches("^[OMF]$")) {
                System.out.println(body);
                return ResponseEntity.status(201).body(body);
            }
        }
        return ResponseEntity.status(404).body("My bad master Darth Vader");
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object>match(@RequestParam(name = "userName") String userName, @RequestParam(name = "userCountry") String userCountry) {
        final List<Map<String, String>> profiles = List.of(
            Map.of("name", "machin","twitter","machin45"),
            Map.of("name","Charf-Eddin Belhadj", "twitter", "Zboubosor Fin Stratège du Cul"),
            Map.of("name","Loick Caillon","twitter","Fin puceau des abysses"),
            Map.of("name","Alexandre Boutrig", "twitter", "Branlix3000"),
            Map.of("name","truc","twitter","bidule-chouette")
        );
        return ResponseEntity.ok().body(profiles.get(new Random().nextInt(profiles.size())));
    }
}
