package bsuir.course.project.Repository;

import bsuir.course.project.Entity.Person;
import bsuir.course.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
