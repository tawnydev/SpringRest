package com.tawnydev.SprintRest;

import com.tawnydev.SprintRest.entity.Person;
import com.tawnydev.SprintRest.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class SprintRestApplicationTests {

    @MockBean
    private PersonRepository personRepository;

    @Bean
    private PersonRepository getPersonRepository(){
        return Mockito.mock(PersonRepository.class);
    }

    @Test
    public void getPerson() {
        Person p = new Person();
        p.setFirstName("Thomas");
        p.setLastName("Lanse");
        ArrayList<Person> people = new ArrayList<>();
        people.add(p);
        Mockito.when(personRepository.findByLastName("Lanse")).thenReturn(people);

        List list= personRepository.findByLastName("Lanse");
        Assertions.assertEquals(p, list.get(0));
    }

}
