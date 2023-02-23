package gr.hua.reference.letters.spring.server.controller;

import gr.hua.reference.letters.spring.server.model.Request;
import gr.hua.reference.letters.spring.server.model.Student;
import gr.hua.reference.letters.spring.server.model.Teacher;
import gr.hua.reference.letters.spring.server.repository.RequestRepository;
import gr.hua.reference.letters.spring.server.repository.StudentRepository;
import gr.hua.reference.letters.spring.server.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/")
    public String addRequest(@RequestParam Integer studentId, @RequestParam Integer teacherId,
                             @RequestParam String recipientName, @RequestParam String recipientEmailAddress) {
        Request request = new Request();
        Student student = studentRepository.findStudentById(studentId);
        request.setStudent(student);
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        request.setTeacher(teacher);
        request.setRecipientName(recipientName);
        request.setRecipientEmailAddress(recipientEmailAddress);
        requestRepository.save(request);
        return "Added new request to database!";
    }

    @GetMapping("/")
    public Iterable<Request> getRequests() {
        return requestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Request findRequestById(@PathVariable Integer id) {
        return requestRepository.findRequestById(id);
    }

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
