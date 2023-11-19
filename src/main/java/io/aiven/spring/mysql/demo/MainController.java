package io.aiven.spring.mysql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email){
        User springUser = new User ();
        springUser.setName(name);
        springUser.setEmail(email);
        userRepo.save(springUser);
        return springUser;
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }
}
