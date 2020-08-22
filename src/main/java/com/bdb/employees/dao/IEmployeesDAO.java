package com.bdb.employees.dao;

import com.bdb.employees.dao.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeesDAO extends JpaRepository<Employee, Integer> {
}
