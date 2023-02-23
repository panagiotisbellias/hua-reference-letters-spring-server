package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {

    Request findRequestById(Integer id);

}
