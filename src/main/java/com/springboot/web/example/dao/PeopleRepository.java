package com.springboot.web.example.dao;

import com.springboot.web.example.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {

    List<People> findByAddress(String name);

    People findByNameAndAddress(String name, String address);

    @Query("select p from People p where p.name=:name and p.address=:address")
    People withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    People withNameAndAddressNameQuery(String name, String address);
}
