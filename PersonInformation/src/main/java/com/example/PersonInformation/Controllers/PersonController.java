package com.example.PersonInformation.Controllers;

import com.example.PersonInformation.Entities.ErrorHandling;
import com.example.PersonInformation.Entities.PersonChange;
import com.example.PersonInformation.Services.PersonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello, World";
    }


    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<?> createPersons(@RequestBody PersonChange persons) {
        try {
            return new ResponseEntity<>(personService.createPerson(persons), HttpStatus.OK);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(new ErrorHandling(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPeople() {
        try {
            return new ResponseEntity<>(personService.getAllPeople(), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(new ErrorHandling(e.getMessage()), HttpStatus.NOT_FOUND);
        }

    }
}
