package com.springboot.web.example.dao;

import com.springboot.web.example.ApplicationTest;
import com.springboot.web.example.domain.Student;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRepositoryTest extends ApplicationTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findByNameStartsWithTest(){
        Student student = studentRepository.findByNameStartsWith("小");
        Assert.assertTrue(student != null);
    }
}
