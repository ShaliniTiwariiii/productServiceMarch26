package org.example.productservicemarch26.models;

import jakarta.persistence.Cache;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.productservicemarch26.dtos.FakeStoreProductDto;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private int qty;
    @ManyToOne
    private Category category;

    public static Product from (FakeStoreProductDto fakeStoreProductDto){
        if(fakeStoreProductDto!=null){
           Product product = new Product();
           product.setId(fakeStoreProductDto.getId());
              product.setTitle(fakeStoreProductDto.getTitle());
                product.setDescription(fakeStoreProductDto.getDescription());
                product.setPrice(fakeStoreProductDto.getPrice());
                product.setImageUrl(fakeStoreProductDto.getImage());
                Category category = new Category();
                category.setTitle(fakeStoreProductDto.getCategory());
                return product;
        }
        return null;
    }
}
