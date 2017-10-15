
package normal.synchronizedthread;

public class NormalSynchronizedThread extends Thread{

long N_startTime, N_endTime, S_startTime, S_endTime, normalDuration, synchronizedDuration;

public static void main(String[] args){
    NormalSynchronizedThread normalsynchronized = new NormalSynchronizedThread();
    normalsynchronized.start();
}

    public void run() {
        //Normal Thread
        N_startTime = System.nanoTime();
            for (int i = 0; i <= 10; i++) {
                Thread.currentThread().getName();
            }
        N_endTime = System.nanoTime();
        normalDuration = N_endTime - N_startTime;
        System.out.printf("Normal Thread = %.8f seconds %n", normalDuration/1000000000.0);
        
        //Synchronized Thread
        S_startTime = System.nanoTime();
        synchronized (this) {
            for (int i = 0; i <= 10; i++) {
                Thread.currentThread().getName();
            }
        }
        S_endTime = System.nanoTime();
        synchronizedDuration = S_endTime - S_startTime;
        System.out.printf("Synchronized Thread = %.8f seconds %n", synchronizedDuration/1000000000.0);
    }
}
    

