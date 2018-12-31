package it.marvinflock.tree.controller;

import it.marvinflock.tree.domain.Person;
import it.marvinflock.tree.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trees")
public class MainController {

  private final PersonService personService;

  @Autowired
  public MainController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/people/{username}")
  public Person getPerson(@PathVariable String username) {
    Person newPerson = new Person();
    newPerson.setFirstNames(List.of(username));
    return personService.save(newPerson);
  }

  @GetMapping("/people")
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }

  @DeleteMapping("/people")
  public void deleteAllPeople() {
    personService.deleteAllPeople();
  }
}
