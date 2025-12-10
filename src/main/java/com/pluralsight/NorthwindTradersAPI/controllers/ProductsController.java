package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.data.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductsController {

    private ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao){

        this.productDao = productDao;
    }

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productDao.getAll();
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProduct(@PathVariable int id){
        return productDao.getById(id);
    }

    @RequestMapping(path="/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        System.out.println("CREATE PRODUCT");
        //return productDao.insert(product);
        return new Product();
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.PUT)
    public void updateProduct( @PathVariable int id, @RequestBody Product product){
        productDao.update(id,product);
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id){
        productDao.delete(id);
    }


}
