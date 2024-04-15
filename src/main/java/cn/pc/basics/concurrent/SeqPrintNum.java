package cn.pc.basics.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SeqPrintNum {

    private static final Object LOCK = new Object();
    private static volatile int count = 0;
    private static final int MAX = 100;

    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) {
//        method1();
        List<Condition> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Condition condition = REENTRANT_LOCK.newCondition();
            list.add(condition);
            Worker worker = new Worker(i , list);
            worker.start();
        }

    }


    static class Worker extends Thread{

        int index;
        List<Condition> conditionList;


        public Worker(int index, List<Condition> conditionList) {
            super("t" + index);
            this.index = index;
            this.conditionList = conditionList;
        }

        private void signalNext(){
            int nextIndex = (index + 1) % conditionList.size();
            conditionList.get(nextIndex).signal();
        }

        @Override
        public void run() {
            while (true){
                REENTRANT_LOCK.lock();
                try {

                    if (count % 3 != index) {
                        conditionList.get(index).await();
                    }
                    if (count > 100){
                        signalNext();
                        return;
                    }
                    if (count <= MAX){
                        System.out.println(Thread.currentThread().getName() + ":   " + count);
                    }
                    count++;
                    signalNext();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    REENTRANT_LOCK.unlock();
                }


            }


        }
    }


















    public static void method1(){
        Thread t1 = new Thread(new MyThread(0) , "t1");
        Thread t2 = new Thread(new MyThread(1) , "t2");
        Thread t3 = new Thread(new MyThread(2) , "t3");
        t1.start();
        t2.start();
        t3.start();

    }
    static class MyThread implements Runnable{

        private int index;

        MyThread(int index){
            this.index = index;
        }

        @Override
        public void run() {
            while (count < MAX){
                synchronized (LOCK){
                    try {
                        while (count % 3 != index) {
                            LOCK.wait();
                        }
                        if (count <= MAX){
                            System.out.println(Thread.currentThread().getName() + ":   " + count);
                        }
                        count++;
                        LOCK.notifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }
    }




}
