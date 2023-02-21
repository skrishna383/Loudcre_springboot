package com.example.loudcre.api;

import com.example.loudcre.model.Person;
import com.example.loudcre.service.PersonService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/vi/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@NotNull @RequestBody Person p){
        personService.addPerson(p);

    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person selectPersonById(@PathVariable("id") UUID id){
        return personService.selectPersonById(id).orElse(null);
    }
    @DeleteMapping(path="{id}")
    public int deletePersonById(@PathVariable("id") UUID id) {
        return personService.deletePersonById(id);
    }
    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @NotNull @RequestBody Person p) {
        return personService.updatePersonById(id,p);
    }
}
