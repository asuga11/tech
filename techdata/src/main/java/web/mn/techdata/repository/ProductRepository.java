package web.mn.techdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.mn.techdata.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
