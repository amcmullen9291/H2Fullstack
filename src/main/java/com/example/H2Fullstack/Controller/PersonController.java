package com.example.H2Fullstack.Controller;

import com.example.H2Fullstack.Entity.Person;
import com.example.H2Fullstack.Repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person) throws URISyntaxException {
        Person savedPerson = personRepository.save(person);
        return ResponseEntity.created(new URI("/people/" + savedPerson.getId())).body(savedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person currentPerson = personRepository.findById(id).orElseThrow(RuntimeException::new);
        currentPerson.setFirstName(person.getFirstName());
        currentPerson.setLastName(person.getLastName());
        currentPerson.setEmail(person.getEmail());
        currentPerson = personRepository.save(person);

        return ResponseEntity.ok(currentPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
