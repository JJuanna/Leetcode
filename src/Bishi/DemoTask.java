package Bishi;

import java.util.Arrays;
import java.util.List;

public class DemoTask implements Runnable {

    // 这里将lock对象换成 Lock(ReentrantLock) 进行lock/unlock也是可以的
    private static final Object lock = new Object();
    private static final int MAX = 30;
    private static int current = 0;

    private int index;

    public DemoTask(int i) {
        index = i;
    }

    @Override
    public void run() {
        while (current < MAX) {
            synchronized (lock) {
                if ((current < MAX) && (current % 3 == index)) {
                    System.out.println((char) ('A' + current % 3));
                    current++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Thread> threadList = Arrays.asList(
                new Thread(new DemoTask(0)),
                new Thread(new DemoTask(1)),
                new Thread(new DemoTask(2))
        );

        threadList.forEach(Thread::start);
    }
}
