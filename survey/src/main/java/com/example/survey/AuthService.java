package com.example.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository rep;

    public User signup(User user) {
        return rep.save(user);
    }

    public String login(String id, String password){
        User user = rep.findById(id).orElse(null);
        if(user.getPassword().equals(password)){
            return "success";
        }
        return "password error";
    }
    
    public User findByUsername(String id) throws NotFoundException {
        User user = rep.findById(id).orElse(null);;
        if(user == null) throw new NotFoundException();
        return user;
    }

    public List<User> getUserList(){
        return rep.findAll();
    }

    public void DeleteUser(String id){
        rep.deleteById(id);
    }
    
    public User EditUser(User user){
        User editUser = rep.findById(user.getId()).orElse(null);
        editUser.setName(user.getName());
        editUser.setEmail(user.getEmail());
        editUser.setPassword(user.getPassword());
        return rep.save(editUser);
    }
}
