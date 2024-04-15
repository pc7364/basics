package cn.pc.basics.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SeqPrintThread {

    public static void main(String[] args) throws InterruptedException {
        method2();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }


    static class MyThread implements Runnable{

        MyThread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        private CountDownLatch countDownLatch;

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName());
            }catch (Exception e){

            }finally {
                countDownLatch.countDown();
            }


        }
    }


    public static void method2() throws InterruptedException {
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(1);

        Thread t1 = new Thread(new MyThread(countDownLatch1) , "t1");
        Thread t2 = new Thread(new MyThread(countDownLatch2) , "t2");
        Thread t3 = new Thread(new MyThread(countDownLatch3) , "t3");

        t1.start();
        countDownLatch1.await();
        t2.start();
        countDownLatch2.await();
        t3.start();

    }


    public void method1(){
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"t1");

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        },"t2");
        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        },"t3");


        t3.start();
        t2.start();
        t1.start();
    }



}
