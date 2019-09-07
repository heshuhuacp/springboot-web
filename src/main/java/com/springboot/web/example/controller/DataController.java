package com.springboot.web.example.controller;

import com.springboot.web.example.dao.PeopleRepository;
import com.springboot.web.example.domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    PeopleRepository personRepository;

    @RequestMapping("/save")
    public People save(String name, String address, Integer age){

        People p = personRepository.save(new People(null, name, age, address));
        return p;
    }

    @RequestMapping("/findlkmByAddress")
    public List<People> findByAddress(String address){
        List<People> list = personRepository.findByAddress(address);
        return list;
    }

    @RequestMapping("/findByNameAndAddress")
    public People findByNameAndAddress(String name, String address){

        People person = personRepository.findByNameAndAddress(name, address);
        return person;
    }

    @RequestMapping("/withNameAndAddressQuery")
    public People withNameAndAddressQuery(String name, String address){
        People person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }

    @RequestMapping("/withNameAndAddressNameQuery")
    public People withNameAndAddressNameQuery(String name, String address){
        People person = personRepository.withNameAndAddressNameQuery(name, address);
        return person;
    }

    @RequestMapping("/sort")
    public List<People> sort(){
        List<People> personList = personRepository.findAll(new
                Sort(Sort.Direction.ASC, "age"));
        return personList;
    }

    @RequestMapping("/page")
    public Page<People> page(){
        Page<People> pagePerson = personRepository.findAll(new PageRequest(1, 2));
        return pagePerson;
    }


}
