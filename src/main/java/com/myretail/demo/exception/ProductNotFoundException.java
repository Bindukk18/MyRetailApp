package com.myretail.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 
 * @author Bindumalini
 * The Class ProductNotFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found")
public class ProductNotFoundException extends RuntimeException{
}
