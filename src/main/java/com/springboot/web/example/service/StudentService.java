package com.springboot.web.example.service;

import com.springboot.web.example.domain.Student;

public interface StudentService {

    Student saveWithRollBack(Student student);

    Student saveWithNoRollback(Student student);
}
