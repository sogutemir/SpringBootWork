package org.work.springworkv3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springworkv3.core.results.DataResult;
import org.work.springworkv3.core.results.ErrorDataResult;
import org.work.springworkv3.core.results.Result;
import org.work.springworkv3.core.results.SuccessDataResult;
import org.work.springworkv3.model.concretes.Student;
import org.work.springworkv3.services.concretes.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<DataResult<List<Student>>> getAllStudents() {
        DataResult<List<Student>> result = studentService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Student>> getStudentById(@PathVariable Long id) {
        Student result = studentService.getById(id).getData();
        if (result != null) {
            return ResponseEntity.ok(new SuccessDataResult<>(result));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDataResult<>("Student not found"));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Result> addStudent(@RequestBody Student student) {
        Result result = studentService.addStudent(student);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteStudent(@PathVariable Long id) {
        Result result = studentService.deleteStudentById(id);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<Student>> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        DataResult<Student> result = studentService.updateStudentById(id, student);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
