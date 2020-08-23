package com.bdb.employees.dao.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "full_name", unique = true)
    private String fullName;

    @NotNull
    @Column(name = "function_role")
    private String function;

    @Column(name = "boss_id", nullable = true)
    private Integer bossId;

}
