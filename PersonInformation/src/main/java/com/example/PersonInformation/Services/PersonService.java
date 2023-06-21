package com.example.PersonInformation.Services;

import com.example.PersonInformation.Entities.PersonChange;
import com.example.PersonInformation.Models.Person;
import com.example.PersonInformation.Repositories.PersonRepository;
import com.sun.jdi.InternalException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {
   @Autowired(required = false)
   PersonRepository personRepository;


    public Person createPerson(PersonChange person) {
        Person newperson;

        try {
            newperson = new Person(person.firstname, person.lastname, person.age, person.occupation, person.ssnnum);

            personRepository.save(newperson);

        }catch(RuntimeException e){
            throw new InternalException(
                    String.format("A person already exists with that SSN!"));
        }
        return newperson;
    }



    public List<Person> getAllPeople() {
        try {
            return personRepository.queryPerson();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Unable to get information"));

        }
    }
}
