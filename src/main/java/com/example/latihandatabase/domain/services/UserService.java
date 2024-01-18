package com.example.latihandatabase.domain.services;

import com.example.latihandatabase.models.entities.User;
import com.example.latihandatabase.models.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User save(User user){
        return userRepo.save(user);
    }

    public User findOne(long id){
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent()){
            return null;
        }

        return user.get();
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public void removeOne (Long id){
        userRepo.deleteById(id);
    }

//    public List<User> findByName (String name){
//        return userRepo.findBynameContains(name);
//    }

}
