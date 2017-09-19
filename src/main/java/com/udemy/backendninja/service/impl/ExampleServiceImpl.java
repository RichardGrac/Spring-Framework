package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService") //Generará un bean que se va a iniciar en el arranque del servidor
public class ExampleServiceImpl implements ExampleService {

    public static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Richard",21));
        people.add(new Person("Jorge",25));
        people.add(new Person("Sergio",28));
        people.add(new Person("Tommy",30));
        LOG.info("HELLO FROM SERVICE");
        return people;
    }
}
