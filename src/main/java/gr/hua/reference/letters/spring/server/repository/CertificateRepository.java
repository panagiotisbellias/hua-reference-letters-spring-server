package gr.hua.reference.letters.spring.server.repository;

import gr.hua.reference.letters.spring.server.model.Certificate;
import org.springframework.data.repository.CrudRepository;

public interface CertificateRepository extends CrudRepository<Certificate, Integer> {

    Certificate findCertificateById(Integer id);

}
