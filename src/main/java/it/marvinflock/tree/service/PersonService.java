package it.marvinflock.tree.service;

import it.marvinflock.tree.domain.Person;
import it.marvinflock.tree.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> getAllPeople() {
    return personRepository.findAll();
  }

  public void deleteAllPeople() {
    personRepository.deleteAll();
  }

  public Person save(Person person) {
    return personRepository.save(person);
  }
}
