package com.ch.dev.async.handler;

public class HbTask extends AbstractTask<String> {

    public HbTask(){
        super();
    }

    public void putIfNot(String str){
        if(!isExist(str)){
            put(str);
        }
    }

    @Override
    public void handler(String o) {
        System.out.println(o);
    }
}
