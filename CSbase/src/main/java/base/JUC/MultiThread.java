package base.JUC;


/**
 * @author wbq
 * @version 1.0
 * @title MultiThread
 * @description
 * @create 2024/10/7 21:36
 */

public class MultiThread {
    private static final Object lock = new Object();
    private static int count = 1;
    private static final int MAX_COUNT = 10;

    public static void main(String[] args) {
        Runnable printOdd = () -> {
            synchronized (lock) {
                while (count < MAX_COUNT) {
                    if (count % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Runnable printEven = () -> {
            synchronized (lock) {
                while (count < MAX_COUNT) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread1 = new Thread(printOdd, "OddThread");
        Thread thread2 = new Thread(printEven, "EvenThread");
        thread1.start();
        thread2.start();
    }

}
