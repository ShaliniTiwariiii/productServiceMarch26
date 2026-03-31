package org.example.productservicemarch26.services;

import org.example.productservicemarch26.exceptions.ProductNotFoundException;
import org.example.productservicemarch26.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id,Product product);
    void deleteProduct(long id);
}
