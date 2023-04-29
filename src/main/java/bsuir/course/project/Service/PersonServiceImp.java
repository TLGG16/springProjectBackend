package bsuir.course.project.Service;

import bsuir.course.project.Entity.Person;
import bsuir.course.project.Interfaces.PersonService;
import bsuir.course.project.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Transactional
    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }
    @Transactional
    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
    @Transactional
    @Override
    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }
    @Transactional
    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    @Transactional
    @Override
    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }
}
