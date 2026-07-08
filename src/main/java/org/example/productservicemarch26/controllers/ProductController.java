package org.example.productservicemarch26.controllers;

import org.example.productservicemarch26.exceptions.ProductNotFoundException;
import org.example.productservicemarch26.models.Product;
import org.example.productservicemarch26.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product>getProductById(@PathVariable("productId")Long productId ) throws ProductNotFoundException {
        if(productId<=0){
            throw new IllegalArgumentException("productId must be greater than 0");
        }
        Product product=productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    public List<Product>getAllProducts(){
        return productService.getAllProducts();
    }
    public ResponseEntity< List<Product>>searchProducts(@RequestParam String searchText){
        List<Product> Products=productService.searchProducts(searchText);
        return ResponseEntity.ok(Products);
    }

}
