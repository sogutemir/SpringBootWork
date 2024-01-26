package org.work.springbootwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springbootwork.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
