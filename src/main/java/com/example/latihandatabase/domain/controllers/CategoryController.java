package com.example.latihandatabase.domain.controllers;

import com.example.latihandatabase.domain.services.CategoryService;
import com.example.latihandatabase.models.entities.Category;
import com.example.latihandatabase.models.entities.SearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catagories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //Tanpa sorting
    @PostMapping("/search/{size}/{page}")
    public Iterable<Category> findByName(@RequestBody SearchData searchData,
                                         @PathVariable("size") int size,
                                         @PathVariable("page") int page){
        PageRequest pageable = PageRequest.of(page, size);
        return categoryService.findByName(searchData.getSearchKey(), pageable);
    }

    //menggunakan sorting
    @PostMapping("/search/{size}/{page}/{sort}")
    public Iterable<Category> findByName(@RequestBody SearchData searchData,
                                         @PathVariable("size") int size,
                                         @PathVariable("page") int page,
                                         @PathVariable("sort") String sort){

        PageRequest pageable = PageRequest.of(page, size, Sort.by("id"));

        if (sort.equalsIgnoreCase("desc")){
            pageable =  PageRequest.of(page, size, Sort.by("id").descending());
        }

        return categoryService.findByName(searchData.getSearchKey(), pageable);
    }
}
