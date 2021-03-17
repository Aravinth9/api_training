package fr.esiea.ex4A.hello;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> responseEntity(@RequestParam Map<String, String> body) {
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
        return ResponseEntity.status(404).body("Erreur format");
    }
}
