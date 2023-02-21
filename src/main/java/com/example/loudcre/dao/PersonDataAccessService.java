package com.example.loudcre.dao;

import com.example.loudcre.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class PersonDataAccessService implements PersonDao{
    private final JdbcTemplate jdbcTemplate;
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person p) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "Select id,name from person";
        return jdbcTemplate.query(sql,(resultSet,i)->{
            return new Person (
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"));
        });

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "Select id,name from person where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet,i)->{
            return new Person (
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"));
    }));
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person p) {
        return 0;
    }
}
