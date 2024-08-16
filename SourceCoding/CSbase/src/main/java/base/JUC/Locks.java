package base.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

/**
 * @author wbq
 * @version 1.0
 * @title Lock
 * @description
 * @create 2024/7/14 21:50
 */

public class Locks {
    public static void main(String[] args) throws InterruptedException {
        testLockAndCondition();
        testReentrantLock();
        testReadWriteLock();
    }

    private static void testLockAndCondition() {
        ReentrantLock testLock = new ReentrantLock();
        Condition condition = testLock.newCondition();
        new Thread(() -> {
            testLock.lock();
            System.out.println("thread 1 ready to wait.");
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread 1 exec over.");
            testLock.unlock();
        }).start();
        new Thread(() -> {
            testLock.lock();
            System.out.println("thread 2 start to release condition");
            condition.signal();
            System.out.println("thread 2 exec over.");
            testLock.unlock();
        }).start();
    }

    private static void testReentrantLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        new Thread(() -> {
            System.out.println("thread 2 want to get lock");
            lock.lock();
            System.out.println("thread 2 get lock successfully.");
        }).start();
        lock.unlock();
        System.out.println("thread 1 release lock 1 times");
        TimeUnit.SECONDS.sleep(1);
        lock.unlock();
        System.out.println("thread 1 release lock 2 times");
    }


    private static void testReadWriteLock() throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t1 = new Thread(() -> {
            lock.readLock().lock();
            System.out.println("thread 1 get read lock");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.readLock().unlock();
        });
        t1.start();

        // note 读锁可以重复获取
        Thread t2 = new Thread(() -> {
            lock.readLock().lock();
            System.out.println("thread 2 get read lock");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.readLock().unlock();
        });
        t2.start();

        // note 线程 3想要获取写锁，但是由于线程 1,2获取了读锁，因此获取不到
        Thread t3 = new Thread(() -> {
            lock.writeLock().lock();
            System.out.println("thread 3 get write lock");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.writeLock().unlock();
        });
        t3.start();
    }


    private static void testAQS() {

    }

}
