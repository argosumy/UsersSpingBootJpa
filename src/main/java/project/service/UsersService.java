package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Users;
import project.repository.UsersRepository;

import java.util.List;
@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers(){
        List<Users> users = usersRepository.findAll();
        for(Users user:users){
            System.out.println(user);
        };
        return users;
    }

    public Users createUser(){
        Users users = new Users();
        users.setFirstName("Ivan");
        users.setPhone("0994869938");
        usersRepository.save(users);
        return users;
    }


}
