package com.joeljebitto.employeeCRUD.dao;

import java.util.List;

import com.joeljebitto.employeeCRUD.entity.Employee;

public interface EmployeeDAO {
  /**
   * Saves the given employee to the database.
   *
   * @param employee the employee to save
   */
  void saveEmployee(Employee employee);

  /**
   * Retrieves an employee by their ID.
   *
   * @param id the ID of the employee
   * @return the employee with the specified ID, or null if not found
   */
  Employee getEmployee(int id);

  /**
   * Retrieves all employees from the database.
   *
   * @return a list of all employees
   */
  List<Employee> getAllEmployees();

  /**
   * Deletes an employee by their ID.
   *
   * @param id the ID of the employee to delete
   */
  void deleteEmployee(int id);
}
