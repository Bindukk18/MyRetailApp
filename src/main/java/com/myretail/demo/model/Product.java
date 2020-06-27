package com.myretail.demo.model;

import org.springframework.data.annotation.Id;

import java.util.Map;
/**
 * 
 * @author Bindumalini
 * The Class Product.
 */
public class Product {

    /** The product id. */
    @Id
    public String productId;
    
    /** The title. */
    public String title;
    
    /** The current price. */
    public Map<String, String> current_price;

    /**
     * Instantiates a new product.
     */
    public Product() {}

    /**
     * Instantiates a new product.
     *
     * @param productId the product id
     * @param title the title
     * @param current_price the current price
     */
    public Product(String productId, String title, Map<String,String> current_price) {
        this.productId = productId;
        this.title = title;
        this.current_price = current_price;
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the id.
     *
     * @param productId the new id
     */
    public void setId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the current price.
     *
     * @return the current price
     */
    public Map<String, String> getCurrent_price() {
        return current_price;
    }

    /**
     * Sets the current price.
     *
     * @param current_price the current price
     */
    public void setCurrent_price(Map<String, String> current_price) {
        this.current_price = current_price;
    }


}
