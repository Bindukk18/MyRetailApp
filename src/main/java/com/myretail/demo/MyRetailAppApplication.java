package com.myretail.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myretail.demo.dao.ProductRepository;
import com.myretail.demo.model.Product;

/**
 * 
 * @author Bindumalini
 * The Class MyRetailAppApplication.
 */
@SpringBootApplication
public class MyRetailAppApplication {

    /** The repository. */
    @Autowired
    private ProductRepository repository;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
         SpringApplication.run(MyRetailAppApplication.class, args);
    }

    /**
     * Insert sample data into the MongoDB database.
     */
    @PostConstruct
    public void storeSampleData() {
        Map<String, String> map = new HashMap<>();
        map.put("value", "13.49");
        map.put("currency_code", "USD");
        repository.save(new Product("13860428", "The Big Lebowski (Blu-ray) (Db name)", map));

        map.put("value", "500");
        map.put("currency_code", "USD");
        repository.save(new Product("15117729", "Apple IPAD", map));
        
        
        map.put("value", "400");
        map.put("currency_code", "USD");
        repository.save(new Product("15117744", "Levis T-shirt", map));
        
        map.put("value", "1045");
        map.put("currency_code", "USD");
        repository.save(new Product("15117745", "Apple pro", map));
    }

}