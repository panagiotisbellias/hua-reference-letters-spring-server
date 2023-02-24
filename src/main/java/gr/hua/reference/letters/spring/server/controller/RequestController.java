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
@RequestMapping("/app/requests")
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

    private String printRequests(Iterable<Request> requests) {
        String response =
                "<pre>ID\tStudent Name\t\tTeacher Name\t\tRecipient</br>";

        while (requests.iterator().hasNext()) {
            Request request = requests.iterator().next();
            response += request.getId() + "\t" + request.getStudent().getFirstName() + " " + request.getStudent().getLastName() + "\t\t" +
                    request.getTeacher().getFirstName() + " " + request.getTeacher().getLastName() + "\t" +
                    request.getRecipientName() + " - " + request.getRecipientEmailAddress();
        }

        response = "Hello admin! The reference letter requests are: </br>" + response;
        return response + "</pre>";
    }

    @GetMapping("/")
    public String getRequests() {
        Iterable<Request> requests = requestRepository.findAll();
        if (!requests.iterator().hasNext()) {
            return "Navigate to http://localhost:8080/app/requests?username= and your username to see your reference letter requests";
        }

        return printRequests(requests);

    }

    @GetMapping("/{id}")
    public Request findRequestById(@PathVariable Integer id) {
        return requestRepository.findRequestById(id);
    }

    @GetMapping("/")
    public String getRequestsByUser(@Param(value = "username") String username) {
        Iterable<Request> requests = null;
        Student student = studentRepository.findStudentByUsername(username);
        if (student != null) {
            requests = requestRepository.findRequestsByStudent(student);
        } else {
            Teacher teacher = teacherRepository.findTeacherByUsername(username);
            if (teacher != null) {
                requests = requestRepository.findRequestsByTeacher(teacher);
            }
        }

        if (requests != null) {
            return printRequests(requests);
        }

        return "No data are available for you!";
    }

}
