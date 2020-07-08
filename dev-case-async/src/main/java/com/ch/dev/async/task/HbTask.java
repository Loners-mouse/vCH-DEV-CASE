package com.ch.dev.async.task;

import com.ch.dev.async.cache.HbCache;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HbTask {

    public static HbTask getInstance(){
        return SingleTon.instance.getHbTask();
    }

    private HbTask(){
        this.consumerTask();
    }

    private enum SingleTon{
        instance;
        private HbTask hbTask;
        SingleTon(){
            hbTask = new HbTask();
        }

        public HbTask getHbTask(){
            return hbTask;
        }
    }

    public void productTask(String id){
        TaskBlockQueue.putIfNot(id);
    }

    public void consumerTask(){
        new Thread(new ConsumerThread()).start();
    }

    private class ConsumerThread implements Runnable{

        public void run() {
            while (true){
                String id = TaskBlockQueue.take();
                HbCache.putHb(id,true);
            }
        }
    }

    private static class TaskBlockQueue{
        private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(1000);

        public static void putIfNot(String id) {
            if (!isExist(id)) {
                put(id);
            }
        }

        public static boolean isExist(String id) {
            return blockingQueue.contains(id);
        }

        public static void put(String id) {
            try {
                blockingQueue.put(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static String take() {
            try {
                return blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void clear() {
            blockingQueue.clear();
        }
    }
}
