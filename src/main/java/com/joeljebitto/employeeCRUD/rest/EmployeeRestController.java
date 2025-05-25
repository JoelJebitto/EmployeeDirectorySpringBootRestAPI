package com.joeljebitto.employeeCRUD.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joeljebitto.employeeCRUD.dao.EmployeeDAO;
import com.joeljebitto.employeeCRUD.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private EmployeeDAO employeeDAO;

  public EmployeeRestController(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @GetMapping("/")
  public String home() {
    return "Welcome to the Employee Management System!";
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeDAO.getAllEmployees();
  }
}
