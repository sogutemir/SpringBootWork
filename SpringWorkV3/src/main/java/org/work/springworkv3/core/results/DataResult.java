package org.work.springworkv3.core.results;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result{

    private final T data;
    public DataResult(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }
    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

}
