package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.Request;
import gr.hua.reference.letters.spring.server.model.Student;
import gr.hua.reference.letters.spring.server.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {

    Request findRequestById(Integer id);
    Iterable<Request> findRequestsByStudent(Student student);
    Iterable<Request> findRequestsByTeacher(Teacher teacher);


}
