package com.joeljebitto.employeeCRUD.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joeljebitto.employeeCRUD.entity.Employee;
import com.joeljebitto.employeeCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  public EmployeeRestController(EmployeeService theEmployeeService) {
    employeeService = theEmployeeService;
  }

  @GetMapping("/")
  public String home() {
    return "Welcome to the Employee Management System!";
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/employees/{employeesId}")
  public Employee getEmployee(@PathVariable int employeesId) {
    Employee theEmployee = employeeService.getEmployee(employeesId);
    if (theEmployee == null) {
      throw new RuntimeException("Employee Id Not Found - " + employeesId);
    }
    return theEmployee;
  }

  @PostMapping("/employees")
  public void addEmployee(@RequestBody Employee theEmployee) {
    theEmployee.setId(0);
    employeeService.saveEmployee(theEmployee);

  }
}
