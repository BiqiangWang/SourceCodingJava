package base.JUC;

import java.util.concurrent.*;

/**
 * @author wbq
 * @version 1.0
 * @title ThreadPool
 * @description
 * @create 2024/7/14 16:02
 */

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 基础线程池
        useThreadPool();

        // 基于Executors预设封装的线程池
        useFromExecutors();

        // 执行带返回值的任务
        useWithReturns();

    }


    private static void useThreadPool() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 8; i++) {
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " start to run");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " stopped");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(executor.getPoolSize());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(executor.getPoolSize());

        executor.shutdownNow();
    }

    private static void useFromExecutors() throws ExecutionException, InterruptedException {
        // note 固定大小的线程池
        ExecutorService exec1 = Executors.newFixedThreadPool(10);
        exec1.shutdownNow();

        // note 单个线程的线程池, 这里套一层的主要目的是避免用户通过强转为ThreadPoolExecutor来修改参数线程池参数。
        ExecutorService exec2 = Executors.newSingleThreadExecutor();
        exec2.shutdownNow();

        // note 无核心线程，且无上限
        ExecutorService exec3  = Executors.newCachedThreadPool();
        exec3.shutdownNow();

        // note 这一线程池主要用于：周期性地执行任务 or 在指定的时间执行任务
        ScheduledExecutorService exec4 = Executors.newScheduledThreadPool(10);
        exec4.scheduleWithFixedDelay(() -> System.out.println("hello world!"), 3, 3, TimeUnit.SECONDS);
        exec4.shutdown();
    }

    private static void useWithReturns() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<String> rsp = exec.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return "return info";
        });
        System.out.println(rsp.get());
        exec.shutdownNow();
    }
}
