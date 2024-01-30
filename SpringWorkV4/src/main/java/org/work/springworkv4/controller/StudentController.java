package org.work.springworkv4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springworkv4.core.results.DataResult;
import org.work.springworkv4.core.results.ErrorDataResult;
import org.work.springworkv4.core.results.Result;
import org.work.springworkv4.core.results.SuccessDataResult;
import org.work.springworkv4.dto.StudentDTO;
import org.work.springworkv4.services.concretes.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<StudentDTO>>> getAllStudents(){
        DataResult<List<StudentDTO>> result = studentService.getAllStudents();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<StudentDTO>> getStudentById(@PathVariable  Long id){
        DataResult<StudentDTO> result = studentService.getStudentById(id);
        if (result != null) {
            return ResponseEntity.ok(new SuccessDataResult<>(result).getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDataResult<>("Product not found"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addStudents(@RequestBody StudentDTO studentDto){
        Result result = studentService.addStudent(studentDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDto) {
        Result result = studentService.updateStudent(id, studentDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteStudent(@PathVariable Long id) {
        Result result = studentService.deleteStudent(id);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
