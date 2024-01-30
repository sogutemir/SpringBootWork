package org.work.springworkv4.services.concretes;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.work.springworkv4.core.results.*;
import org.work.springworkv4.dto.StudentDTO;
import org.work.springworkv4.model.Student;
import org.work.springworkv4.repository.StudentRepository;
import org.work.springworkv4.services.abstracts.IStudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<StudentDTO>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> dtos = students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(dtos, "Students are listed");
    }

    @Override
    public DataResult<StudentDTO> getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return new ErrorDataResult<>(null, "Student not found");
        }
        StudentDTO dto = modelMapper.map(student, StudentDTO.class);
        return new SuccessDataResult<>(dto, "Student is found");
    }

    @Override
    public Result addStudent(StudentDTO studentDto) {
        if(studentDto == null){
            return new ErrorResult("Student is null");
        }
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
        return new SuccessResult("Student is added");
    }

    @Override
    public Result updateStudent(Long id, StudentDTO studentDto) {
        if (studentDto == null) {
            return new ErrorResult("Student is null");
        }
        Student existingStudent = studentRepository.findById(id)
                .orElse(null);
        if (existingStudent == null) {
            return new ErrorResult("Student not found");
        }
        modelMapper.map(studentDto, existingStudent);
        studentRepository.save(existingStudent);
        return new SuccessResult("Student updated successfully");
    }


    @Override
    public Result deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            return new ErrorResult("Student not found");
        }
        studentRepository.deleteById(id);
        return new SuccessResult("Student deleted successfully");
    }

}
