package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.model.Users;
import project.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping(value = "allUsers")
    public String getAllUsers(){
        List<Users> users = new ArrayList<>(usersService.getAllUsers());

        return users.toString();
    }

    @GetMapping(value = "create")
    public String createUser(){
        return usersService.createUser().toString();
    }
}
