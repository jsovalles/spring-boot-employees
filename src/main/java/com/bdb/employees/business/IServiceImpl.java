package com.bdb.employees.business;

import com.bdb.employees.dao.entity.Employee;

import java.util.List;

public interface IServiceImpl {

    List<Employee> listEmployees();

    Employee createEmployee(Employee employee);

    Employee getEmployee(Integer bossId);
}
