package Bishi;

import java.util.concurrent.ExecutorService;

public class threadServer {
    // 运行线程
//    ExecutorService executorService;
    public static void main(String[] args) {
        Thread t1 = new Thread(new thread("t1"));
        Thread t2 = new Thread(new thread("t2"));
        t2.start();
        t1.start();
    }
}
