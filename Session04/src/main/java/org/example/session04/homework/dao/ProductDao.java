package org.example.session04.homework.dao;


import org.example.session04.homework.model.Product;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDao {
    public List<Product> findAll() {
        return Arrays.asList(
                new Product(1, "Sản phẩm A"),
                new Product(2, "Sản phẩm B")
        );
    }

    public Product findById(int id) {
        return new Product(id, "Sản phẩm số " + id);
    }
}
