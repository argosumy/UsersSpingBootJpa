package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Users;


public interface UsersRepository extends JpaRepository<Users,Integer> {


}
