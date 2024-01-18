package com.example.latihandatabase.domain.controllers;

import com.example.latihandatabase.domain.dto.ResponseData;
import com.example.latihandatabase.domain.services.ProductService;
import com.example.latihandatabase.models.entities.Product;
import com.example.latihandatabase.models.entities.SearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors){

        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus (false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus (false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productService.removeOne(id);
    }

    @PostMapping("/search/name")
    public Product getProductByName(@RequestBody SearchData searchData) {
        return productService.findProductByName(searchData.getSearchKey());
    }

    @PostMapping("/search/nameLike")
    public List<Product> getProductByNameLike(@RequestBody SearchData searchData) {
        return productService.findProductByNameLike(searchData.getSearchKey());
    }

}
