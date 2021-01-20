package project.service;

import project.model.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    List<User> getUserById(int id);
    List<User> getUserByPhone(String phone);
    User createUser(User user);
    void updateUser(User user);
    void deleteUserById(int id);


}
