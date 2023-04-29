package bsuir.course.project.Service;

import bsuir.course.project.Entity.User;
import bsuir.course.project.Interfaces.UserService;
import bsuir.course.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> existsByLoginPassword(User user) {
        return userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    @Transactional
    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
