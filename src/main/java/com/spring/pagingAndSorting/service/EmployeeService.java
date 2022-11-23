package com.spring.pagingAndSorting.service;

import com.spring.pagingAndSorting.EmployeeCriteriaRepository;
import com.spring.pagingAndSorting.EmployeeRepository;
import com.spring.pagingAndSorting.model.Employee;
import com.spring.pagingAndSorting.model.EmployeePage;
import com.spring.pagingAndSorting.model.EmployeeSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            EmployeeCriteriaRepository employeeCriteriaRepository
    ) {
        this.employeeRepository = employeeRepository;
        this.employeeCriteriaRepository = employeeCriteriaRepository;
    }

    public Page<Employee> getEmployees(
            EmployeePage employeePage,
            EmployeeSearchCriteria employeeSearchCriteria
    ) {
        return employeeCriteriaRepository.findAllWithFilters(
                employeePage,
                employeeSearchCriteria
        );
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
