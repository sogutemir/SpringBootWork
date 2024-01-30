package org.work.springworkv3.services.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.springworkv3.core.results.*;
import org.work.springworkv3.model.concretes.Student;
import org.work.springworkv3.repository.StudentRepository;
import org.work.springworkv3.services.abstracts.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    @Override
    public DataResult<List<Student>> getAll() {
        return new SuccessDataResult<List<Student>>(studentRepository.findAll(), "All students listed.");
    }

    @Override
    public DataResult<Student> getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return new SuccessDataResult<>(student.get(), "Student with id: " +
                    id + " listed.");
        }
        return new ErrorDataResult<>("Student with id: " + id + " not found.");
    }

    @Override
    public Result addStudent(Student student) {
        if(student != null)
        {
            studentRepository.save(student);
            return new SuccessResult("Student added.");
        }
        return new ErrorResult("Student not added.");
    }

    @Override
    public Result deleteStudentById(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return new SuccessResult("Student with id: " + id + " deleted.");
        }
        return new ErrorResult("Student with id: " + id + " not found.");
    }

    @Override
    public DataResult<Student> updateStudentById(Long id, Student student) {
        student.setId(id);
        if(studentRepository.existsById(id)){
            studentRepository.save(student);
            return new SuccessDataResult<>(student, "Student with id: " + id + " updated.");
        }
        return new ErrorDataResult<>("Student with id: " + id + " not found.");
    }
}
