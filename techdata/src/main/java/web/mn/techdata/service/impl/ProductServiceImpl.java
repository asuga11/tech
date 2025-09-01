package web.mn.techdata.service.impl;

import org.springframework.stereotype.Service;
import web.mn.techdata.model.Product;
import web.mn.techdata.repository.ProductRepository;
import web.mn.techdata.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        if (existing != null) {
            existing.setName(updatedProduct.getName());
            existing.setDescription(updatedProduct.getDescription());
            existing.setPrice(updatedProduct.getPrice());
            existing.setCategory(updatedProduct.getCategory());
            return productRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
