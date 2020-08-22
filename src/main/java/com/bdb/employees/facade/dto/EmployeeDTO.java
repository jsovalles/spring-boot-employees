package com.bdb.employees.facade.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private String fullName;

    private String function;

    private EmployeeDTO boss;

}
