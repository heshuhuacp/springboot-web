package com.springboot.web.example.dao;

import com.springboot.web.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;

    public void setString(String key, String value){
        valOpsStr.set(key, value);
    }

    public String getString(String key){
        return valOpsStr.get(key);
    }

    public void save(Person person){
        valOps.set(person.getId(), person);
    }

    public Person getPerson(String id){
        return (Person)valOps.get(id);
    }
}
