package org.example.productservicemarch26.exceptions;

public class ProductNotFoundException extends Exception{
    private Long productId;
    private String message;
    public ProductNotFoundException(Long productId,String message) {
        super(message);
        this.productId = productId;
    }
}