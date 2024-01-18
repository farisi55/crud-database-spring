package com.example.latihandatabase.models.repos;

import com.example.latihandatabase.models.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;
import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findBynameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findProductByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);

}
