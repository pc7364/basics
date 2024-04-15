package cn.pc.basics.concurrent;



import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CasDemo {


    private static Unsafe unsafe;

    static {
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static  long valueOffset ;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public static class Counter{

        private volatile int value;

        private Counter(int initValue){
            this.value = initValue;
        }

        public void increment() {

            int current;
            int next;
            do {
                current = value;
                next = current + 1;
            }while (!unsafe.compareAndSwapInt(this , valueOffset ,current , next));
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
        Thread[] threads = new Thread[10];
        for (int i = 0 ; i < threads.length ; i++){
            threads[i] = new Thread(() -> {
                for (int j = 0 ; j< 1000; j++){
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(counter.value);
    }

}
