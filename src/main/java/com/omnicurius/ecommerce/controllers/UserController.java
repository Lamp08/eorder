package com.omnicurius.ecommerce.controllers;

import com.omnicurius.ecommerce.Models.Cart;
import com.omnicurius.ecommerce.Models.User;
import com.omnicurius.ecommerce.repository.CartCrudRepository;
import com.omnicurius.ecommerce.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce/user")
public class UserController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private CartCrudRepository cartCrudRepository;


    @PutMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody User user){

        userCrudRepository.save(user);
        return "user added successfully";
    }

}
