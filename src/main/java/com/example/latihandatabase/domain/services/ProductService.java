package com.example.latihandatabase.domain.services;

import com.example.latihandatabase.models.entities.Product;
import com.example.latihandatabase.models.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(long id){
        Optional<Product> product = productRepo.findById(id);
        if(!product.isPresent()){
            return null;
        }

        return product.get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void removeOne (Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByName (String name){
        return productRepo.findBynameContains(name);
    }

    public Product findProductByName(String name) {
        return productRepo.findProductByName(name);
    }

    public List<Product> findProductByNameLike(String name){
        return productRepo.findProductByNameLike("%"+name+"%");
    }

}
