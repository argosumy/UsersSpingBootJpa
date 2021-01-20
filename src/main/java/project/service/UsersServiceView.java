package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.User;
import project.repository.UsersRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UsersServiceView implements UsersService  {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceView(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAllBy();
    }

    @Override
    public List<User> getUserById(int id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<User> getUserByPhone(String phone) {
        return usersRepository.findByPhone(phone);
    }

    @Override
    public User createUser(User user) {
        usersRepository.save(user);
        return user;
    }
    @Override
    public void updateUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void deleteUserById(int id){
        usersRepository.removeUsersById(id);
    }
}
