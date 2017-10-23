package issue6;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class issue_6 extends Thread {

    private static int random;
    private static long number;
    private static double startTime, duration;
    private static ArrayList list = new ArrayList<>();
    private static int max = 1;

    static Thread sequential = new Thread() {
        public void run() {
            startTime = System.nanoTime();
            for (int i = 0; i < list.size(); i++) {
                if ((int) list.get(i) > max) {
                    max = (int) list.get(i);
                }
            }
            duration = System.nanoTime() - startTime;
            System.out.printf("Sequential Program = %.8f seconds.%n", duration / 1000000000.0);
        }
    };

    static Thread concurrent = new Thread() {
        public void run() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                startTime = System.nanoTime();
                for (int i = 0; i < list.size(); i++) {
                    if ((int) list.get(i) > max) {
                        max = (int) list.get(i);
                    }
                }
                Thread.currentThread().getName();
                duration = System.nanoTime() - startTime;
                System.out.printf("Concurrent Program = %.8f seconds.%n", duration / 1000000000.0);
            });
            executor.shutdown();
        }
    };

    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            number = (Math.round(Math.random() * 1000000));
            random = (int) number;
            list.add(random);
        }
        sequential.start();
        concurrent.start();
    }
}
