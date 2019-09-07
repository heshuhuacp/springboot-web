package com.springboot.web.example.service.impl;

import com.springboot.web.example.dao.StudentRepository;
import com.springboot.web.example.domain.Student;
import com.springboot.web.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Student saveWithRollBack(Student student) {

        Student stu = studentRepository.save(student);
        if(stu.getName().equals("小何")){
            throw new IllegalArgumentException("小何已经存在，数据将回滚");
        }
        return stu;

    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Student saveWithNoRollback(Student student) {
        Student stu = studentRepository.save(student);
        if(stu.getName().equals("小何")){
            throw new IllegalArgumentException("小郑已经存在，数据将回滚");
        }
        return stu;
    }
}
