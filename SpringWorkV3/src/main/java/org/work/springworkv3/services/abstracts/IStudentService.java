package org.work.springworkv3.services.abstracts;

import org.work.springworkv3.core.results.DataResult;
import org.work.springworkv3.core.results.Result;
import org.work.springworkv3.model.concretes.Student;

import java.util.List;

public interface IStudentService {
    DataResult<List<Student>> getAll();
    DataResult<Student> getById(Long id);
    Result addStudent(Student student);
    Result deleteStudentById(Long id);
    DataResult<Student>updateStudentById(Long id, Student student);
}
