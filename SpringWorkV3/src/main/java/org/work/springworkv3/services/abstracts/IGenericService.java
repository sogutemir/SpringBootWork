package org.work.springworkv3.services.abstracts;

import org.springframework.stereotype.Service;
import org.work.springworkv3.core.results.DataResult;
import org.work.springworkv3.core.results.Result;

import java.util.List;

@Service
public interface IGenericService <T, ID> {
    DataResult<List<T>> getAll();

    DataResult<T> getById(ID id);

    Result add(T entity);

    Result deleteById(ID id);

    DataResult<T> updateById(ID id, T entity);
}
