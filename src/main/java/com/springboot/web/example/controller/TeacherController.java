package com.springboot.web.example.controller;

import com.springboot.web.example.domain.Teacher;
import com.springboot.web.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value= "/rollBack", method = RequestMethod.POST
            , produces = "application/json;charset=UTF-8"
            , consumes = "application/json;charset=UTF-8")
    public Teacher rollback(@RequestBody Teacher teacher){

        return teacher;
    }

    @RequestMapping("/noRollBack")
    public Teacher noRollback(Teacher teacher){

        return teacher;
    }


}
