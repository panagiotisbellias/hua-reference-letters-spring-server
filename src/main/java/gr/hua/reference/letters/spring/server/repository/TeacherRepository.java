package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer id);

}
