package it.marvinflock.tree.controller;

import it.marvinflock.tree.domain.Person;
import it.marvinflock.tree.exception.PersonNotFoundException;
import it.marvinflock.tree.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PeopleController {

  private final PersonService personService;

  @Autowired
  public PeopleController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * get a single person
   *
   * @param id of person
   * @return person
   */
  @GetMapping("/people/{id}")
  public Person getPerson(@PathVariable long id) {
    Optional<Person> optionalPerson = personService.findById(id);
    if (optionalPerson.isEmpty()) {
      throw new PersonNotFoundException();
    }
    return optionalPerson.get();
  }

  /**
   * lists all people of a tree
   *
   * @return List of people of a tree
   */
  @GetMapping("/people")
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }

  /**
   * deletes a tree
   */
  @DeleteMapping("/people")
  public void deleteAllPeople() {
    personService.deleteAllPeople();
  }
}
