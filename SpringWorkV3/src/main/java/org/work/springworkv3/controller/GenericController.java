package org.work.springworkv3.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springworkv3.core.results.DataResult;
import org.work.springworkv3.core.results.Result;
import org.work.springworkv3.services.abstracts.IGenericService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenericController<T, ID> {

    private final IGenericService<T, ID> service;

    @GetMapping("/api/{className}")
    public ResponseEntity<DataResult<List<T>>> getAll() {
        DataResult<List<T>> result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/{className}/{id}")
    public ResponseEntity<DataResult<T>> getById(@PathVariable ID id) {
        DataResult<T> result = service.getById(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/{className}")
    public ResponseEntity<Result> add(@RequestBody T entity) {
        Result result = service.add(entity);
        return result.isSuccess()
                ? ResponseEntity.status(201).body(result)
                : ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/api/{className}/{id}")
    public ResponseEntity<DataResult<T>> updateById(@PathVariable ID id, @RequestBody T entity) {
        DataResult<T> result = service.updateById(id, entity);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/{className}/{id}")
    public ResponseEntity<Result> deleteById(@PathVariable ID id) {
        Result result = service.deleteById(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.notFound().build();
    }
}