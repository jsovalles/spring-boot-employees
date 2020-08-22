package com.bdb.employees.utils;

import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class DummyMocks {

    public List<EmployeeDTO> listEmployeeDTO(){

        List<EmployeeDTO> out = new ArrayList<>();

        EmployeeDTO employee1 = new EmployeeDTO();
        employee1.setFullName("Karen Suarez");
        employee1.setFunction("Gerente General");
        out.add(employee1);

        EmployeeDTO employee2 = new EmployeeDTO();
        employee2.setFullName("Javier Espinoza");
        employee2.setFunction("Jefe de Proyectos");
        employee2.setBoss(new EmployeeDTO());
        employee2.getBoss().setFullName("Karen Suarez");
        out.add(employee2);

        return out;

    }

    public List<Employee> listEmployeeDAO(){

        List<Employee> out = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setFullName("Karen Suarez");
        employee1.setFunction("Gerente General");
        out.add(employee1);

        Employee employee2 = new Employee();
        employee2.setFullName("Javier Espinoza");
        employee2.setFunction("Jefe de Proyectos");
        employee2.setBossId(1);
        out.add(employee2);

        return out;

    }

    public EmployeeDTO getEmployeeDTOIn(){

        EmployeeDTO employee = new EmployeeDTO();
        employee.setFullName("Jose Velez");
        employee.setFunction("Product Owner");

        return employee;

    }

    public Employee getEmployeeDAO(){

        Employee employee = new Employee();
        employee.setFullName("Jose Velez");
        employee.setFunction("Product Owner");
        employee.setBossId(1);

        return employee;

    }

    public EmployeeDTO getEmployeeDTOOut(){

        EmployeeDTO employee = new EmployeeDTO();
        employee.setFullName("Jose Velez");
        employee.setFunction("Product Owner");
        employee.setBoss(new EmployeeDTO());
        employee.getBoss().setFullName("Karen Suarez");

        return employee;

    }
}
