package issue7;

import java.util.ArrayList;
import java.util.Random;

public class Issue_7 extends Thread {

    static ArrayList<Integer> arrList = new ArrayList<>();
    static Random random = new Random();
    static int[] randomNo = new int[1000000];

    static Thread Mean = new Thread() {
        public void run() {
            int sum = 0;
            int mean;
            for (int i = 0; i < randomNo.length; i++) {
                sum = sum + randomNo[i];
            }
            mean = sum / randomNo.length;
            System.out.println("Mean: " + mean);
        }
    };

    static Thread Mode = new Thread() {
        public void run() {
            int[] count = new int[randomNo.length];
            for (int i = 0; i < randomNo.length; i++) {
                count[randomNo[i]]++;
            }
            int mode = count.length - 1;
            for (int i = count.length - 2; i >= 0; i--) {
                if (count[i] > count[mode]) {
                    mode = i;
                }
            }
            System.out.println("Mode: " + mode);
        }
    };

    static Thread Median = new Thread() {
        public void run() {
            int mid = randomNo.length / 2;
            if (randomNo.length % 2 == 1) {
                System.out.println(randomNo[mid]);
            } else {
                System.out.println("Median: " + (randomNo[mid - 1] + randomNo[mid]) / 2.0);
            }
        }
    };

    public static void main(String args[]) throws InterruptedException {

        for (int i = 0; i < randomNo.length; i++) {
            randomNo[i] = (int) (Math.round(Math.random() * 1000000));
        }
        Mean.start();
        Mode.start();
        Median.start();

    }
}
