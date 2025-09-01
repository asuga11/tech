package web.mn.departments.service.impl;

import web.mn.departments.model.Departments;
import web.mn.departments.repository.DepartmentsRepository;
import web.mn.departments.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Override
    public List<Departments> getAllDepartments() {
        return departmentsRepository.findAll();
    }

    @Override
    public Optional<Departments> getDepartmentById(Long id) {
        return departmentsRepository.findById(id);
    }

    @Override
    public Departments createDepartment(Departments department) {
        return departmentsRepository.save(department);
    }

    @Override
    public Departments updateDepartment(Long id, Departments department) {
        Optional<Departments> existing = departmentsRepository.findById(id);
        if (existing.isPresent()) {
            Departments d = existing.get();
            d.setName(department.getName());
            d.setDescription(department.getDescription());
            d.setManager(department.getManager());
            d.setLocation(department.getLocation());
            return departmentsRepository.save(d);
        } else {
            return null; // Энд алдааны зохицуулалт хийж болно
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentsRepository.deleteById(id);
    }
}
