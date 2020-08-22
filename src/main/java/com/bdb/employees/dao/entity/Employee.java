package com.bdb.employees.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", unique = true)
    private String fullName;

    private String function;

    @Column(name = "boss_id")
    private Integer bossId;

}
