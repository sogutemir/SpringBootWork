package org.work.springworkv2.core.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class DataResult<T> extends Result{

    private T data;
    public DataResult(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }
    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
