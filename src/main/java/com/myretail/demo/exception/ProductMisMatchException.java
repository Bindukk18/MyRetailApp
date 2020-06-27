package com.myretail.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 
 * @author Bindumalini
 * The Class ProductMisMatchException.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ProductId in request header and body doesn't match.")
public class ProductMisMatchException extends RuntimeException{
}
