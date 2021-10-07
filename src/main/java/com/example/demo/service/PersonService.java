package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDaO;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDaO) {
        this.personDaO = personDaO;
    }

    public int addPerson(Person person) {
        return personDaO.addPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDaO.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDaO.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDaO.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDaO.updatePersonById(id, person);
    }
}
