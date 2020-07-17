package com.ch.dev.async.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractTask<T> implements Runnable{

    private static final int size = 1024;

    private final BlockingQueue<T> queue;

    public AbstractTask(){
        this(size);
    }

    public AbstractTask(int size){
        if(size <= 0){
            size = this.size;
        }
        queue = new LinkedBlockingQueue<T>(size);
    }

    public boolean put(T t){
        return queue.offer(t);
    }

    public boolean isExist(T t){
        return queue.contains(t);
    }

    public abstract void handler(T t);

    @Override
    public void run(){
        while (true){
            try {
                T t = queue.take();
                handler(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
