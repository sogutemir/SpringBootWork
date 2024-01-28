package org.work.springworkv2.core.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Result {
    private  boolean success;
    private  String message;

    public Result(boolean success) {
        this.success = success;
    }

}
