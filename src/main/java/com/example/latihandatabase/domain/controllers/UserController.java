package com.example.latihandatabase.domain.controllers;

import com.example.latihandatabase.domain.dto.ResponseData;
import com.example.latihandatabase.domain.services.UserService;
import com.example.latihandatabase.models.request.SignUpRq;
import com.example.latihandatabase.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User viewUser(@PathVariable("id") Long id){
        return userService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<User>> signUp(@Valid @RequestBody SignUpRq signUpRq, Errors errors){

        ResponseData<User> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus (false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        //responseData.setPayload(productService.save(product));
        return ResponseEntity.ok(responseData);
    }
}
