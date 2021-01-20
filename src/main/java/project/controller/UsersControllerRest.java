package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project.model.User;
import project.service.UsersService;
import project.service.UsersServiceRest;


@RestController
public class UsersControllerRest {
    private final UsersService usersService;

    @Autowired
    public UsersControllerRest(UsersServiceRest usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "rest/allUsers")
    public String getAllUsers(){
        return usersService.getAllUsers().toString();
    }

    @GetMapping(value = "rest/user/id={id}")
    public String getUserById(@PathVariable("id") int id){
        return usersService.getUserById(id).toString();
    }

    @GetMapping(value = "create")
    public String createUser(){
        return usersService.createUser(new User()).toString();
    }
}
