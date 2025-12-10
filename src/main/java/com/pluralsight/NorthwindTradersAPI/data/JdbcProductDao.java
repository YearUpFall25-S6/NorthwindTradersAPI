package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{


    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public Product insert(Product product) {
        return null;
    }

    @Override
    public void update(int id, Product product){

    }

    @Override
    public void delete(int id){

    }
}
