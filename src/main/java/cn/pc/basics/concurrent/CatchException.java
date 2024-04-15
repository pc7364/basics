package cn.pc.basics.concurrent;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.concurrent.CompletableFuture;

public class CatchException {

    static class myUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + "     " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            throw new RuntimeException("抛个异常");
        });
        thread.setUncaughtExceptionHandler(new myUncaughtExceptionHandler());
        thread.start();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->{
            throw new RuntimeException("还是抛个异常");
        });
        future.handle((result , exception) ->{
            if (exception != null){
                System.out.println(exception.getMessage());
            }
            return null;
        });


    }

}
