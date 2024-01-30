package org.work.springworkv4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springworkv4.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
