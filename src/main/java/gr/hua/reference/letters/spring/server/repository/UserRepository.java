package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(Integer id);

}
