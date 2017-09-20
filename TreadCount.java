
package tread.count;

public class TreadCount extends Thread {

    public static void main(String[] args) {
        new Thread(new TreadCount()).start();
    }

    @Override
    public void run() {
        try {
            for (int x = 0; x < 10500; x++) {
                System.out.println(x);
                sleep(5000);
                    if(x % 50 == 0 && x != 0){
                        System.out.println("Reached 50 numbers.");
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}