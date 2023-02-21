package com.example.loudcre.dao;

import com.example.loudcre.model.Person;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("mockDao")
public class MockDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person p) {
        DB.add(new Person(id,p.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> p = selectPersonById(id);
        if (p.isPresent()){
            DB.remove(p.get());
            return  1;
        }
        else{
            return  0;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person p) {
        int ret = deletePersonById(id);
        if (ret==0){
            return ret;
        }
        insertPerson(id,p);
        return ret;
    }
}
