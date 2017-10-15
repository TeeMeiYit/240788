package Week_04;

class TestSleep2 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName());   
            if(Thread.currentThread().getName().equals("Three")){
                System.out.println("*******");
            }
            try {
                // thread to sleep for 5000 milliseconds
                Thread.sleep(5000);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(new TestSleep2(), "One");
        Thread t2 = new Thread(new TestSleep2(), "TWO");
        Thread t3 = new Thread(new TestSleep2(), "Three");

        t1.start();
        try{
            t1.join(1000);
        }catch (Exception e){

        }
        t2.start();
        try{
            t2.join(2000);
        }catch (Exception e){

        }
        t3.start();
        try{
            t3.join(3000);
        }catch (Exception e){

        }
        //System.out.println("*******");
        /*t1.start();
        t1.join(1000);
        t2.start();
        t2.join(2000);
        t3.start();
        t3.join(3000);
*/
    }
}
