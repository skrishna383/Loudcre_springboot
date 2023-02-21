package com.example.loudcre.dao;

import com.example.loudcre.model.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson (UUID id , Person p);
    default int insertPerson (Person p ){
        UUID id = UUID.randomUUID();
        return insertPerson(id,p);
    }
    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person p);
}
