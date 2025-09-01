package mn.myweb.bikes.controller;

import mn.myweb.bikes.model.Bikes;
import mn.myweb.bikes.service.BikesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
public class BikesController {

    private final BikesService bikesService;

    public BikesController(BikesService bikesService) {
        this.bikesService = bikesService;
    }

    // 🔍 Бүх дугуйг авах
    @GetMapping
    public ResponseEntity<List<Bikes>> getAllBikes() {
        return ResponseEntity.ok(bikesService.getAllBikes());
    }

    // 🔍 Нэг дугуйг ID-аар авах
    @GetMapping("/{id}")
    public ResponseEntity<Bikes> getBikeById(@PathVariable Long id) {
        return bikesService.getBikeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➕ Шинэ дугуй нэмэх
    @PostMapping
    public ResponseEntity<Bikes> createBike(@RequestBody Bikes bike) {
        Bikes created = bikesService.createBike(bike);
        return ResponseEntity.ok(created);
    }

    // 🔁 Дугуй шинэчлэх
    @PutMapping("/{id}")
    public ResponseEntity<Bikes> updateBike(@PathVariable Long id, @RequestBody Bikes bike) {
        try {
            Bikes updated = bikesService.updateBike(id, bike);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ❌ Дугуй устгах
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable Long id) {
        bikesService.deleteBike(id);
        return ResponseEntity.noContent().build();
    }
}
