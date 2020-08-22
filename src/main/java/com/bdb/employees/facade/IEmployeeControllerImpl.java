package com.bdb.employees.facade;

import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeControllerImpl {

    List<EmployeeDTO> listEmployees();

    EmployeeDTO createEmployee(EmployeeDTO employee, Integer bossId);

}
