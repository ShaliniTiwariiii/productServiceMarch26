package org.example.productservicemarch26.services;

import org.example.productservicemarch26.dtos.FakeStoreProductDto;
import org.example.productservicemarch26.exceptions.ProductNotFoundException;
import org.example.productservicemarch26.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(long id) throws ProductNotFoundException{
      ResponseEntity<FakeStoreProductDto>responseEntity=
              restTemplate.getForEntity(
                      "https://fakestoreapi.com/products/"+id,
                        FakeStoreProductDto.class
              );
      FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();
      if(fakeStoreProductDto==null){
          throw new ProductNotFoundException(id,"Product with id "+id+" not found");
      }
        return Product.from(fakeStoreProductDto);

    }
    public List<Product> getAllProducts(){
         ResponseEntity<FakeStoreProductDto[]>responseEntity=
                restTemplate.getForEntity(
                          "https://fakestoreapi.com/products",
                          FakeStoreProductDto[].class
                );
         List<Product> products=new ArrayList<>();
         for(FakeStoreProductDto fakeStoreProductDto:responseEntity.getBody()){
             products.add(Product.from(fakeStoreProductDto));
         }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
    public Product updateProduct(Long id,Product product) {
        return null;
    }
    public void deleteProduct(long id){

    }
    private Product from(FakeStoreProductService fakeStoreProductService){
      return null;
    }
}
