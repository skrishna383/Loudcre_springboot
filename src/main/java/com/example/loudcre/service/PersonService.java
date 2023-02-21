package com.example.loudcre.service;

import com.example.loudcre.dao.PersonDao;
import com.example.loudcre.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person p){
        return personDao.insertPerson(p);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> selectPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }
    public int updatePersonById(UUID id, Person p) {
        return personDao.updatePersonById(id,p);
    }


    }
