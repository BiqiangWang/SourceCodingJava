package base.JUC;

import java.util.concurrent.Callable;

/**
 * @author wbq
 * @version 1.0
 * @title ThreadCreate
 * @description
 * @create 2024/7/11 15:00
 */

public class ThreadCreate {

    public static void main(String[] args) throws Exception {
        Thread t1 = new myThead1();
        t1.start();
        new myThread2().run();
        Object msg = new myThread3().call();
        System.out.println(msg);
        
    }


    private static class myThead1 extends Thread {
        @Override
        public void run() {
            System.out.println("hello, extend from Thread library");
        }
    }

    private static class myThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("hello, implement Runnable interface");
        }
    }

    private static class myThread3 implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            System.out.println("hello, implement Callable interface");
            return "msg from callable";
        }
    }
}
