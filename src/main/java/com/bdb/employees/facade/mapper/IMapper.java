package com.bdb.employees.facade.mapper;

import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;

import java.util.List;

public interface IMapper {

    List<EmployeeDTO> listEmployees(List<Employee> employeesDao);

    Employee createEmployeeIn(EmployeeDTO employee, Integer bossId);

    EmployeeDTO createEmployeeOut(Employee daoOut);
}
