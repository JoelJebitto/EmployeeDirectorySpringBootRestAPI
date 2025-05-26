package com.joeljebitto.employeeCRUD.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.joeljebitto.employeeCRUD.entity.Employee;
import com.joeljebitto.employeeCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  private ObjectMapper objectMapper;

  public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
    employeeService = theEmployeeService;
    objectMapper = theObjectMapper;
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

  @PutMapping("/employees")
  public String updateEmployee(@RequestBody Employee theEmployee) {
    employeeService.saveEmployee(theEmployee);
    return "Done";
  }

  @PatchMapping("/employees/{employeesId}")
  public void patchEmployee(@PathVariable int employeesId, @RequestBody Map<String, Object> theMap) {
    Employee theEmployee = employeeService.getEmployee(employeesId);
    if (theEmployee == null) {
      throw new RuntimeException("Employee Id Not Found - " + employeesId);
    }
    if (theMap.containsKey("id")) {
      throw new RuntimeException("Cannot update, employee id is not allowed in request body");
    }
    Employee updatedEmployee = apply(theMap, theEmployee);
    employeeService.saveEmployee(updatedEmployee);

  }

  private Employee apply(Map<String, Object> theMap, Employee theEmployee) {
    ObjectNode employeeNode = objectMapper.convertValue(theEmployee, ObjectNode.class);
    ObjectNode updatedEmployeeNode = objectMapper.convertValue(theMap, ObjectNode.class);
    employeeNode.setAll(updatedEmployeeNode);
    return objectMapper.convertValue(employeeNode, Employee.class);
  }
}
