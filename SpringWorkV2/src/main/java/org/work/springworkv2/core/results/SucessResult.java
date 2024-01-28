package org.work.springworkv2.core.results;

public class SucessResult extends Result{
    public SucessResult(){
        super(true);
    }
    public SucessResult(String message){
        super(true,message);
    }
}
