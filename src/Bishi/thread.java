package Bishi;

import java.util.Random;

public class thread implements Runnable {
    // 创建一个线程
    public int n = 10;
    public String name;

    thread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + n);
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
