package gr.hua.reference.letters.spring.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String homePage(@RequestParam(value = "name", defaultValue = "there") String name) {
        return String.format("Hello %s! This is our home page!", name);
    }

}
