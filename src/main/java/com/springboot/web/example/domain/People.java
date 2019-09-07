package com.springboot.web.example.domain;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Entity指明这是一个和数据库表映射的实体类
 */
@Entity
@NamedQuery(name = "People.withNameAndAddressNameQuery",
query = "select p from People p where p.name=?1 and address=?2")
public class People {

    /**
     * @Id这个属性映射为数据库表的主键
     */
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public People() {
        super();
    }

    public People(Long id, String name, Integer age, String address) {
        this.id= id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
