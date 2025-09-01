package mn.myweb.mytech.controller;

import mn.myweb.mytech.model.Product;
import mn.myweb.mytech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Frontend-ээс хүсэлт ирэхэд зөвшөөрнө
public class ProductController {

    @Autowired
    private ProductService productService;

    // 🟢 Бүх бүтээгдэхүүнийг авах
    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    // 🟢 Шинэ бүтээгдэхүүн нэмэх
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // 🟢 ID-аар бүтээгдэхүүн авах
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // 🔴 Бүтээгдэхүүн устгах
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // 🟡 Бүтээгдэхүүн шинэчлэх (хүсвэл)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product existing = productService.getProductById(id);
        if (existing != null) {
            existing.setName(updatedProduct.getName());
            existing.setPrice(updatedProduct.getPrice());
            existing.setDescription(updatedProduct.getDescription());
            existing.setImageUrl(updatedProduct.getImageUrl());
            existing.setCategory(updatedProduct.getCategory());
            existing.setStock(updatedProduct.getStock());
            return productService.addProduct(existing);
        }
        return null;
    }
}
