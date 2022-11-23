package com.spring.pagingAndSorting.controller;

import com.spring.pagingAndSorting.model.Employee;
import com.spring.pagingAndSorting.model.EmployeePage;
import com.spring.pagingAndSorting.model.EmployeeSearchCriteria;
import com.spring.pagingAndSorting.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(
            EmployeePage employeePage,
            EmployeeSearchCriteria employeeSearchCriteria
    ) {
        return new ResponseEntity<>(
                employeeService.getEmployees(employeePage, employeeSearchCriteria),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                employeeService.addEmployee(employee),
                HttpStatus.CREATED
        );
    }
}
