package com.example.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AuthService authService;

    @GetMapping("/userlist")
    public List<User> GetUsers() {
        return authService.getUserList();
    }

    @GetMapping("/{id}")
    public User GetUser(@PathVariable String id) throws NotFoundException {
        return authService.findByUsername(id);
    }

    @PostMapping("/signup")
    public User SignUpUser(User user){
        return authService.signup(user);
    }

    @PutMapping("/{id}")
    public User PutUser(User user){
        return authService.EditUser(user);
    }

    @GetMapping("/login")
    public String LoginUser(String id,String password){
        try {
            return authService.login(id,password);
        } catch (Exception e) {
            //TODO: handle exception
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable String id){
        try {
            authService.DeleteUser(id);
            return "success";
        } catch (Exception e) {
            //TODO: handle exception
            return "error";
        }
    }

}
