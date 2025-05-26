package com.joeljebitto.employeeCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeljebitto.employeeCRUD.dao.EmployeeRepository;
import com.joeljebitto.employeeCRUD.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {
  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImp(EmployeeRepository theEmployeeRepository) {
    employeeRepository = theEmployeeRepository;
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployee(int id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    Employee theEmployee = null;
    if (employee.isPresent()) {
      theEmployee = employee.get();
    } else {
      throw new RuntimeException("Employee not found");
    }
    return theEmployee;
  }

  @Override
  public void deleteEmployee(int id) {
    employeeRepository.deleteById(id);
  }
}
