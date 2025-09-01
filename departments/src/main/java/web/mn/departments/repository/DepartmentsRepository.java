package web.mn.departments.repository;

import web.mn.departments.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {

    // Нэмэлт хайлтын функцүүд (хэрвээ шаардлагатай бол)
    Departments findByName(String name);

    boolean existsByName(String name);
}
