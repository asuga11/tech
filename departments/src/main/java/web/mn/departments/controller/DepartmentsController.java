package web.mn.departments.controller;

import web.mn.departments.model.Departments;
import web.mn.departments.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    // Бүх хэлтсүүдийг авах
    @GetMapping
    public List<Departments> getAllDepartments() {
        return departmentsService.getAllDepartments();
    }

    // Нэг хэлтсийг ID-гаар авах
    @GetMapping("/{id}")
    public ResponseEntity<Departments> getDepartmentById(@PathVariable Long id) {
        return departmentsService.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Шинэ хэлтэс нэмэх
    @PostMapping
    public ResponseEntity<Departments> createDepartment(@RequestBody Departments department) {
        Departments created = departmentsService.createDepartment(department);
        return ResponseEntity.ok(created);
    }

    // Хэлтэс шинэчлэх
    @PutMapping("/{id}")
    public ResponseEntity<Departments> updateDepartment(@PathVariable Long id, @RequestBody Departments department) {
        Departments updated = departmentsService.updateDepartment(id, department);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Хэлтэс устгах
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentsService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
