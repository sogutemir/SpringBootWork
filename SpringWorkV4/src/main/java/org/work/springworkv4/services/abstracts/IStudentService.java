package org.work.springworkv4.services.abstracts;

import org.work.springworkv4.core.results.DataResult;
import org.work.springworkv4.core.results.Result;
import org.work.springworkv4.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    DataResult<List<StudentDTO>> getAllStudents();
    DataResult<StudentDTO> getStudentById(Long id);
    Result addStudent(StudentDTO studentDto);

    Result updateStudent(Long id, StudentDTO studentDto);

    Result deleteStudent(Long id);

}
