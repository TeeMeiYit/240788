package issue8;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class issue_8 {

    static class CountThread implements Runnable {

        private int countTotal, countT1, countT2;
        private AtomicInteger count = new AtomicInteger();
        private AtomicInteger t1count = new AtomicInteger();
        private AtomicInteger t2count = new AtomicInteger();
        Random randomNo = new Random();

        public void run() {
            do {
                int i = randomNo.nextInt(500) + 3000;
                countTotal = count.incrementAndGet();
                if ("t1".equals(Thread.currentThread().getName())) {
                    countT1 = t1count.incrementAndGet();
                }
                if ("t2".equals(Thread.currentThread().getName())) {
                    countT2 = t2count.incrementAndGet();
                }
            } while (countTotal < 1000);
        }

        public int getTotal() {
            return countTotal;
        }

        public int getCountT1() {
            return countT1;
        }

        public int getCountT2() {
            return countT2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountThread t = new CountThread();
        Thread t1 = new Thread(t, "t1");
        Thread t2 = new Thread(t, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Thread-1 = " + t.getCountT1());
        System.out.println("Thread-2 = " + t.getCountT2());
        System.out.println("TOTAL = " + (t.getCountT1() + t.getCountT2()));

    }
}
