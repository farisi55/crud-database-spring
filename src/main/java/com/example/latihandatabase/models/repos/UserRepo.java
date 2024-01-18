package com.example.latihandatabase.models.repos;

import com.example.latihandatabase.models.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, Long> {
}
