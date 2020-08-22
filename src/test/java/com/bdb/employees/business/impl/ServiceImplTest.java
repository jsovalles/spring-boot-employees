package com.bdb.employees.business.impl;

import com.bdb.employees.dao.IEmployeesDAO;
import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;
import com.bdb.employees.utils.DummyMocks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceImplTest {

    @InjectMocks
    ServiceImpl srv;

    @Mock
    IEmployeesDAO dao;

    DummyMocks dummyMocks;

    @Before
    public void init(){
        dummyMocks = new DummyMocks();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listEmployees() {
        List<Employee> dummyDAO = dummyMocks.listEmployeeDAO();
        Mockito.when(dao.findAll()).thenReturn(dummyDAO);
        List<Employee> out = srv.listEmployees();
        Assert.assertNotNull(out);
    }

    @Test
    public void createEmployee() {
        Employee dummyDAO = dummyMocks.getEmployeeDAO();
        Mockito.when(dao.save(dummyDAO)).thenReturn(dummyDAO);
        Employee out = srv.createEmployee(dummyDAO);
        Assert.assertNotNull(out);
    }

    @Test
    public void getEmployee() {
        Employee dummyDAO = dummyMocks.getEmployeeDAO();
        Mockito.when(dao.getOne(Integer.valueOf(1))).thenReturn(dummyDAO);
        Employee out = srv.getEmployee(1);
        Assert.assertNotNull(out);
    }
}