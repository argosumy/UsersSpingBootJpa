package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.User;
import project.service.UsersService;
import project.service.UsersServiceView;

import java.util.List;


@Controller
public class UsersControllerView {
    private final UsersService usersService;

    @Autowired
    public UsersControllerView(UsersServiceView usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "view/allUsers")
    public String getAllUsers (Model model){
        model.addAttribute("users", usersService.getAllUsers());
        return "users_show";
    }
    @PostMapping(value = "view/user/id")
    public  String userById(Model model, @RequestParam(value = "id", defaultValue = "0") int id){
        List <User> users;
        if(id == 0){
            return "redirect:/view/allUsers";
        }
        else {
            users = usersService.getUserById(id);
        }
        model.addAttribute("users", users);
        return "users_show";
    }

    @GetMapping(value = "view/user/phone")
    public  String userByPhone(Model model, @RequestParam(value = "phone", defaultValue = "0") String phone){
        List <User> users;
        users = usersService.getUserByPhone(phone);
        model.addAttribute("users", users);
        return "users_show";
    }

    @GetMapping(value = "view/user/delete/{user.id}")
    public String deleteUser(@PathVariable("user.id") String id){
        usersService.deleteUserById(Integer.parseInt(id));
        return "redirect:/view/allUsers";
    }

    @GetMapping(value = "view/user/form/{action}/{id}")
    public String goFormCreateUpdateUser(Model model,
                                         @PathVariable(value = "action")String action,
                                         @PathVariable(value = "id")int id){
        model.addAttribute("action",action);
        if(action.equals("update")){
            model.addAttribute("user", usersService.getUserById(id).get(0));
        }else {
            model.addAttribute("user", new User());
        }
        return "user_createUpdate";
    }

    @PostMapping(value = "view/user/{action}")
    public String createUpdateUser(User user,
                                   @PathVariable(value = "action")String action){
        if(action.equals("create"))
            usersService.createUser(user);
        else {
            usersService.updateUser(user);
        }
        return "redirect:/view/allUsers";
    }



}
