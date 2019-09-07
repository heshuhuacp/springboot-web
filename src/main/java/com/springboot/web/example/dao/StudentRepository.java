package com.springboot.web.example.dao;

import com.springboot.web.example.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * spring-boot-starter-data-rest直接将jpa暴露为rest服务
     * @param name
     * @return
     */
    @RestResource(path="nameStartWith", rel = "nameStartWith")
    Student findByNameStartsWith(@Param("name") String name);
}
