package base.DesignPattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wbq
 * @version 1.0
 * @title Single
 * @description
 * @create 2024/10/10 23:10
 */

public class Single {
    static class Test {
        int val;
        Test(int val) {
            this.val = val;
        }
    }

    private volatile int testInstanceCnt = 0;
    private List<Test> list = new ArrayList<>();
    private final Object lock = new Object();

    private Test getRandomTestInstance() {
        Random random = new Random();
        int key = random.nextInt();
        return list.get(key % list.size());
    }

    private Test getTestInstance() {
        if (testInstanceCnt >= 10) {
            return getRandomTestInstance();
        }
        synchronized (lock) {
            Test t = new Test(testInstanceCnt);
            testInstanceCnt++;
            list.add(t);
            return t;
        }
    }
}
