package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{

    private DataSource dataSource;
    private static final Logger log = LoggerFactory.getLogger(JdbcProductDao.class);

    @Autowired
    public JdbcProductDao(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public List<Product> getAll() throws SQLException {

        List<Product> products = new ArrayList<>();

        String query = """
                SELECT
               ProductId,
               ProductName as name,
               CategoryId,
               UnitPrice as price
               FROM products;""";

        try(Connection connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery()){
            while(results.next()){
                int productid = results.getInt(1);
                String productname = results.getString(2);
                int categoryId = results.getInt(3);
                double price = results.getDouble(4);

                Product p = new Product();
                p.setProductId(productid);
                p.setName(productname);
                p.setCategoryId(categoryId);
                p.setPrice(price);

                products.add(p);
            }


        }

        return products;


    }

    @Override
    public Product getById(int id) throws SQLException {

        String query = """
            SELECT
            ProductId,
            ProductName as name,
            CategoryId,
            UnitPrice as price
            FROM products WHERE ProductId = ?;""";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
           ){

            statement.setInt(1, id);

            try(ResultSet results = statement.executeQuery()){
                if(results.next()){
                    int productid = results.getInt(1);
                    String productname = results.getString(2);
                    int categoryId = results.getInt(3);
                    double price = results.getDouble(4);

                    Product p = new Product();
                    p.setProductId(productid);
                    p.setName(productname);
                    p.setCategoryId(categoryId);
                    p.setPrice(price);

                    return p;
                }
                else{
                    return null;
                }
            }
        }
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
