package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findStudentById(Integer id);
    Student findStudentByUsername(String username);

}
