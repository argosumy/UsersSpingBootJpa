package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.User;
import project.repository.UsersRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UsersServiceRest implements UsersService {


    private final UsersRepository usersRepository;
    @Autowired
    public UsersServiceRest(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    @Override
    public List<User> getAllUsers(){
        List<User> users = usersRepository.findAllBy();
        for(User user:users){
            System.out.println(user);
        }
        return users;
    }
    @Override
    public List<User> getUserById(int id){
        return usersRepository.findById(id);
    }

    @Override
    public List<User> getUserByPhone(String phone) {
        return usersRepository.findByPhone(phone);
    }

    @Override
    @Transactional
    public User createUser(User user){
        user.setFirstName("Ivan-Chai");
        user.setLastName("Lozinskiy");
        user.setPhone("0994869938");
        usersRepository.save(user);
        return user;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(int id) {
    }
}
