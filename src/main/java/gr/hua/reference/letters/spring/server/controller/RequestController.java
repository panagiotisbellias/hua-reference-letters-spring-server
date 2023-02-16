package gr.hua.reference.letters.spring.server.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/app")
    public String userRequests(@Param(value = "username") String username) {
        if (username == null) {
            return "Navigate to http://localhost:8080/app?username= and your username to see your reference letter requests";
        }
        String response =
                "<pre>ID\tStudent Name\t\tTeacher Name\t\tReason\t\tSent at</br>";
        if (username.equals("spring1")) {
            response += "1\tSpring Student\t\tSpring Teacher 1\tEducational\t16-02-2023T17:21</br>";
            response += "2\tSpring Student\t\tSpring Teacher 2\tCarrier\t\t16-02-2023T17:22</br>";
        }
        if (username.equals("spring2")) {
            response += "3\tSpring Student 2\tSpring Teacher 1\tEducational\t16-02-2023T17:23</br>";
        }
        if (!username.equals("spring1") && !username.equals("spring2")){
            response = "No data are available for you!";
        }
        response = "Hello " + username + "! Your reference letter requests are: </br>" + response;
        return response + "</pre>";
    }

}
