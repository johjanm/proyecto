package com.jhojanmartinez.proyecto.controller;

import com.jhojanmartinez.proyecto.entity.User;
import com.jhojanmartinez.proyecto.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") long userId) {
        Optional<User> oUser = userService.findById(userId);

        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }
    //update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") long userId) {
        Optional<User> user = userService.findById(userId);

        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        //BeanUtils.copyProperties(userDetails, user.get());
        user.get().setName(userDetails.getName());
        user.get().setSurname(userDetails.getSurname());
        user.get().setAge(userDetails.getAge());
        user.get().setEmail(userDetails.getEmail());
        user.get().setEnabled(userDetails.getEnabled());
        user.get().setPhone(userDetails.getPhone());
        user.get().setAddress(userDetails.getAddress());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }
    //Delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable (value = "id") long userId){

        if (!userService.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.findById(userId);
        return ResponseEntity.ok().build();
    }
    //Read all Users
    @GetMapping
    public List<User> readAll () {

        List<User> users = (List<User>) StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;

    }

}
