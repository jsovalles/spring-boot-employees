package com.bdb.employees.facade.mapper.impl;

import com.bdb.employees.business.impl.ServiceImpl;
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

public class MapperTest {

    @InjectMocks
    Mapper mapper;

    @Mock
    ServiceImpl srv;

    DummyMocks dummyMocks;

    @Before
    public void init(){
        dummyMocks = new DummyMocks();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listEmployees() {
        List<Employee> dao = dummyMocks.listEmployeeDAO();

        //Mockito.when(srv.getEmployee(1)).thenReturn(dummyMocks.getEmployeeDAO());
        List<EmployeeDTO> res = mapper.listEmployees(dao);

        Assert.assertEquals(dao.get(0).getFullName(), res.get(0).getFullName());
        Assert.assertEquals(dao.get(0).getFunction(), res.get(0).getFunction());

    }

    @Test
    public void createEmployeeIn() {
        EmployeeDTO dtoIn = dummyMocks.getEmployeeDTOIn();
        Employee out = mapper.createEmployeeIn(dtoIn, 1);

        Assert.assertEquals(out.getFullName(), dtoIn.getFullName());
        Assert.assertEquals(out.getFunction(), dtoIn.getFunction());
        //Assert.assertEquals(out.getBossId(), Integer.valueOf(1));

    }

    @Test
    public void createEmployeeOut() {
        Employee dao = dummyMocks.getEmployeeDAO();
        //Mockito.when(srv.getEmployee(1)).thenReturn(dummyMocks.getEmployeeDAO());
        EmployeeDTO out = mapper.createEmployeeOut(dao);

        Assert.assertEquals(out.getFullName(), dao.getFullName());
        Assert.assertEquals(out.getFunction(), dao.getFunction());
    }

}