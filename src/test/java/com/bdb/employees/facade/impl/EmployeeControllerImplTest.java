package com.bdb.employees.facade.impl;

import com.bdb.employees.business.IServiceImpl;
import com.bdb.employees.dao.entity.Employee;
import com.bdb.employees.facade.dto.EmployeeDTO;
import com.bdb.employees.facade.mapper.IMapper;
import com.bdb.employees.utils.DummyMocks;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class EmployeeControllerImplTest {

    @InjectMocks
    EmployeeControllerImpl controller;

    @Mock
    IMapper mapper;

    @Mock
    IServiceImpl srv;

    DummyMocks dummyMocks;

    @Before
    public void init(){
        dummyMocks = new DummyMocks();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listEmployees() {

        List<Employee> dummyDAO = dummyMocks.listEmployeeDAO();
        List<EmployeeDTO> dummyDTO = dummyMocks.listEmployeeDTO();
        Mockito.when(srv.listEmployees()).thenReturn(dummyDAO);
        Mockito.when(mapper.listEmployees(dummyDAO)).thenReturn(dummyDTO);
        List<EmployeeDTO> personas = controller.listEmployees();
    }

    @Test
    public void createEmployee() {
        Employee dummyDAO = dummyMocks.getEmployeeDAO();
        EmployeeDTO dummyDTOIn = dummyMocks.getEmployeeDTOIn();
        EmployeeDTO dummyDTOOut = dummyMocks.getEmployeeDTOOut();
        Mockito.when(mapper.createEmployeeIn(dummyDTOIn,1)).thenReturn(dummyDAO);
        Mockito.when(srv.createEmployee(dummyDAO)).thenReturn(dummyDAO);
        Mockito.when(mapper.createEmployeeOut(dummyDAO)).thenReturn(dummyDTOOut);
        EmployeeDTO employee = controller.createEmployee(dummyDTOIn,1);
    }
}