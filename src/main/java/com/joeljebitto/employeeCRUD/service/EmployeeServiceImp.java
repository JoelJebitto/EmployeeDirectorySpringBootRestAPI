package com.joeljebitto.employeeCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeljebitto.employeeCRUD.dao.EmployeeDAO;
import com.joeljebitto.employeeCRUD.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImp(EmployeeDAO theEmployeeDAO) {
    employeeDAO = theEmployeeDAO;
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeDAO.getAllEmployees();
  }
}
