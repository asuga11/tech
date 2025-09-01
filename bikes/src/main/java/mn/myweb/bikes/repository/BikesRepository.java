package mn.myweb.bikes.repository;

import mn.myweb.bikes.model.Bikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikesRepository extends JpaRepository<Bikes, Long> {
    // Нэмэлт хайлтын функцуудыг энд бичиж болно, жишээ нь:
    // List<Bike> findByBrand(String brand);
    // List<Bike> findByAvailableTrue();
}
