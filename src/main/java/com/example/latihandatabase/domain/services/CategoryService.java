package com.example.latihandatabase.domain.services;

import com.example.latihandatabase.models.entities.Category;
import com.example.latihandatabase.models.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public Iterable<Category> findByName(String name, PageRequest pageable){
        return categoryRepo.findByNameContains(name, pageable);
    }

}
