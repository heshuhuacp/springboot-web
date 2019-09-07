package com.springboot.web.example.controller;

import com.springboot.web.example.domain.Student;
import com.springboot.web.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value= "/rollBack"
            , produces = "application/json;charset=UTF-8"
            , consumes = "application/json;charset=UTF-8")
    public Student rollback(@RequestBody Student student){
        return studentService.saveWithRollBack(student);
    }

    @PostMapping(value= "/noRollBack"
            , produces = "application/json;charset=UTF-8"
            , consumes = "application/json;charset=UTF-8")
    public Student noRollback(@RequestBody Student student){
        return studentService.saveWithNoRollback(student);
    }


}
