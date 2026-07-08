package org.example.productservicemarch26.services;

import org.example.productservicemarch26.models.Product;
import org.example.productservicemarch26.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

ProductRepository productRepository ;
public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
}
    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public List<Product> searchProducts(String searchText) {
        if(searchText==null||searchText.isEmpty()){
            return productRepository.findAll();
        }
        return productRepository.findByTitleContainigIgnoreCase(searchText);
    }
}
