package br.com.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductDoesNotExistException extends RuntimeException{
    public ProductDoesNotExistException(long productId){
        super("Product " + productId + " does not exist.");
    }
}
