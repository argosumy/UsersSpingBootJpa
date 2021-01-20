package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.model.User;

import java.util.List;


public interface UsersRepository extends CrudRepository<User,Integer> {
    List<User> findAllBy();
    List<User> findByPhone(String phone);
    List<User> findById(int id);
    void removeUsersById(int id);

}
