package com.springboot.web.example.controller;

import com.springboot.web.example.dao.RedisDao;
import com.springboot.web.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisDao redisDao;

    @RequestMapping("/set")
    public void set(){
        redisDao.setString("bb", "12345678");
    }

    @RequestMapping("/get")
    public String get(){
        return redisDao.getString("bb");
    }

    @RequestMapping("/savePerson")
    public Person save(@RequestBody Person person){
        redisDao.save(person);
        return person;
    }

    @RequestMapping("/getPerson")
    public Person getPerson(@Param("id") String id){
        return redisDao.getPerson(id);
    }

}
