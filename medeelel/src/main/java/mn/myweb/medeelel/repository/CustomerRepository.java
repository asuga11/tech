package mn.myweb.medeelel.repository;

import mn.myweb.medeelel.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Нэмэлт хайлтын функцүүд (хэрвээ хэрэгтэй бол)
    Customer findByEmail(String email);
    boolean existsByPhone(String phone);
}
