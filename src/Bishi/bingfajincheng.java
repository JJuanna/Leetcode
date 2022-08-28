package Bishi;

public class bingfajincheng {

    public static int gax = 4;

    static class Thread1 extends Thread {
        @Override
        public void run() {
            gax = gax + 3;
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(gax);
            gax = 0;
        }
    }

    public static void main(String[] args) {
        Thread1 F5 = new Thread1();
        Thread2 F6 = new Thread2();
        F6.run();
        F5.run();
        for (int i = 0; i < 2; i++) {
            F5.run();
        }
    }
}
