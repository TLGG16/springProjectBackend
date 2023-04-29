package bsuir.course.project.Repository;

import bsuir.course.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByLoginAndPassword(String login, String password);
}
