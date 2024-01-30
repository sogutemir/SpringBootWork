package org.work.springworkv3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springworkv3.model.concretes.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
