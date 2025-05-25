package com.joeljebitto.employeeCRUD.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.joeljebitto.employeeCRUD.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
  // This class will implement the methods defined in EmployeeDAO interface
  // For example, using JPA or Hibernate to interact with the database

  private EntityManager entityManager;

  public EmployeeDAOImp(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void saveEmployee(Employee employee) {
    // Implementation for saving an employee
    entityManager.merge(employee);
  }

  @Override
  public Employee getEmployee(int id) {
    // Implementation for retrieving an employee by ID
    Employee theEmployee = entityManager.find(Employee.class, id);
    return theEmployee; // Placeholder return statement
  }

  @Override
  public List<Employee> getAllEmployees() {
    // Implementation for retrieving all employees
    TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
    List<Employee> employees = query.getResultList();

    return employees; // Placeholder return statement

  }

  @Override
  public void deleteEmployee(int id) {
    // Implementation for deleting an employee by ID
    Employee theEmployee = entityManager.find(Employee.class, id);

    entityManager.remove(theEmployee);
  }

}
