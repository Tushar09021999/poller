package com.api.controller;

import com.api.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAPI {


    public void getEmployees(){
        List<Employee> emp = new ArrayList<>();

        emp.add(new Employee("tushar", 1000, 24));
        emp.add(new Employee("adarsh", 2000, 25));

        for(Employee a:emp){
            System.out.println(a);

        }

    }
}
