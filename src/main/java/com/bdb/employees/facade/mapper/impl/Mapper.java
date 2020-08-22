package com.bdb.employees.facade.mapper.impl;

import com.bdb.employees.business.IServiceImpl;
import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;
import com.bdb.employees.facade.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper implements IMapper {

    @Autowired
    private IServiceImpl srv;

    @Override
    public List<EmployeeDTO> listEmployees(List<Employee> employeesDao) {
        List<EmployeeDTO> out = new ArrayList<>();

        for(Employee dao : employeesDao){
            EmployeeDTO employee = new EmployeeDTO();
            employee.setFullName(dao.getFullName());
            employee.setFunction(dao.getFunction());
            setBoss(dao, employee);
            out.add(employee);
        }
        return out;
    }

    @Override
    public Employee createEmployeeIn(EmployeeDTO employee, Integer bossId) {
        Employee out = new Employee();
        out.setFullName(employee.getFullName());
        out.setFunction(employee.getFunction());
        if(bossId!=null) {
            out.setBossId(bossId);
        }

        return out;
    }

    @Override
    public EmployeeDTO createEmployeeOut(Employee daoOut) {
        EmployeeDTO out = new EmployeeDTO();
        out.setFullName(daoOut.getFullName());
        out.setFunction(daoOut.getFunction());
        setBoss(daoOut,out);

        return out;
    }

    public EmployeeDTO setBoss(Employee dao, EmployeeDTO employee) {
        if(dao.getBossId()!=null){
            Employee boss = srv.getEmployee(dao.getBossId());
            employee.setBoss(new EmployeeDTO());
            employee.getBoss().setFullName(boss.getFullName());
        }

        return employee;
    }
}
