package mn.myweb.mytech.repository;

import mn.myweb.mytech.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
