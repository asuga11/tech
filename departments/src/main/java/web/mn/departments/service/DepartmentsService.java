package web.mn.departments.service;

import web.mn.departments.model.Departments;

import java.util.List;
import java.util.Optional;

public interface DepartmentsService {

    List<Departments> getAllDepartments();

    Optional<Departments> getDepartmentById(Long id);

    Departments createDepartment(Departments department);

    Departments updateDepartment(Long id, Departments department);

    void deleteDepartment(Long id);
}
