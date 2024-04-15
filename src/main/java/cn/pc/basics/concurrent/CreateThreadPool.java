package cn.pc.basics.concurrent;

import java.util.concurrent.*;

public class CreateThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,2,50L,TimeUnit.MILLISECONDS , new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy()
        );
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(
                2,2,50L,TimeUnit.MILLISECONDS , new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(
                2,2,50L,TimeUnit.MILLISECONDS , new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(
                2,2,50L,TimeUnit.MILLISECONDS , new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

}
