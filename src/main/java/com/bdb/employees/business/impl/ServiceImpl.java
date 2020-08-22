package com.bdb.employees.business.impl;

import com.bdb.employees.business.IServiceImpl;
import com.bdb.employees.dao.IEmployeesDAO;
import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IServiceImpl {

    @Autowired
    private IEmployeesDAO employeeDao;

    @Override
    public List<Employee> listEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee getEmployee(Integer bossId) {
        return employeeDao.getOne(bossId);
    }
}
