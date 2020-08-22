package com.bdb.employees.facade.impl;

import com.bdb.employees.business.IServiceImpl;
import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.IEmployeeControllerImpl;
import com.bdb.employees.facade.dto.EmployeeDTO;
import com.bdb.employees.facade.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:4200")
public class EmployeeControllerImpl implements IEmployeeControllerImpl {

    @Autowired
    private IMapper mapper;

    @Autowired
    private IServiceImpl srv;

    @Override
    @GetMapping
    public List<EmployeeDTO> listEmployees() {

        List<EmployeeDTO> dtoOut = mapper.listEmployees(srv.listEmployees());

        return dtoOut;
    }

    @Override
    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee, @RequestParam(name = "bossId") Integer bossId) {

        Employee daoOut = srv.createEmployee(mapper.createEmployeeIn(employee,bossId));

        EmployeeDTO dtoOut = mapper.createEmployeeOut(daoOut);

        return dtoOut;

    }

}
