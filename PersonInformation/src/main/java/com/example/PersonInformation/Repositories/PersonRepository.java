package com.example.PersonInformation.Repositories;

import com.example.PersonInformation.Models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query(
            value = "select * from public.person",
            nativeQuery = true
    )
    List<Person> queryPerson();

}
