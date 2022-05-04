package br.com.springboot.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    // Array que armazena todos os novos usuários
    private List<User> users = new ArrayList<>();
    
    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        User user = new User();
        Optional<User> userFind = users.stream().filter(user -> user.getId() = id).findFirst();
        return user;

        if(userFind.isPresent()){
            return userFind.get();
        }
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list(){
        return users;
    }
}