package com.springboot.web.example.controller;

import com.springboot.web.example.ApplicationTest;
import com.springboot.web.example.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentControllerTest extends ApplicationTest {

    @Autowired
    private StudentController studentController;

    @Test
    public void noRollbackTest(){
        Student student = new Student();
        student.setName("赵六");
        student.setAge(28);
        student.setAddress("深圳宝安");
        Student responseStu = studentController.noRollback(student);
        Assert.assertTrue(responseStu != null);
    }

    @Test
    public void rollbackTest(){
        Student student = new Student();
        student.setName("赵六");
        student.setAge(28);
        student.setAddress("深圳宝安");
        Student responseStu = studentController.rollback(student);
        Assert.assertTrue(responseStu != null);
    }

}
