package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    void createUser(User user);
    void deleteUser(User user);
    void deleteUserById(Integer id);
    void updateUser(User user);
    Optional<User> existsByLoginPassword(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);

}
