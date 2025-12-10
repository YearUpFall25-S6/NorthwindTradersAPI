package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getAll() throws SQLException;
    Product getById(int id) throws SQLException;
    Product insert(Product product) ;
    void update(int id, Product product) ;
    void delete(int id) ;
}
