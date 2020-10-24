package com.example.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository rep;

    public User save(User u){
        return rep.save(u);
    }

    public User getById(String id){
        return rep.findById(id).orElse(null);
    }

    public List<User> getAll(){
        return rep.findAll();
    }

    public void delete(String id){
        rep.deleteById(id);
    }
}
