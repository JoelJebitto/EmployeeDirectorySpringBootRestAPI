package com.joeljebitto.employeeCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joeljebitto.employeeCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
