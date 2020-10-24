package com.example.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> GetUsers(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public User GetUser(@PathVariable String id){
        return service.getById(id);
    }
    @PostMapping("/")
    public User PostUser(User user){
        return service.save(user);
    }
    @PutMapping("/{id}")
    public User PutUser(@PathVariable String id,User user){
        User oldUser = service.getById(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return service.save(oldUser);
    }
    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable String id){
        service.delete(id);
        return id;
    }
 
    @GetMapping("/getdata")
    public List<User> GetDataUsers() {
        return service.getAll();
    }
}
