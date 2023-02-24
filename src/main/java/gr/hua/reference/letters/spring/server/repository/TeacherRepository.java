package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer id);
    Teacher findTeacherByUsername(String username);


}
