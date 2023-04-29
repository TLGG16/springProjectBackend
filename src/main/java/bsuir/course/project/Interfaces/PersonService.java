package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Person;
import bsuir.course.project.Entity.User;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void createPerson(Person person);
    void deletePerson(Person person);
    void deletePersonById(Integer id);
    void updatePerson(Person person);
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Integer id);
}
