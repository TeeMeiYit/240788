
package MyThreadTwo;

public class MyThreadTwo extends Thread {

    public static void main(String[] args) {
        MyThreadTwo t1 = new MyThreadTwo();
        MyThreadTwo t2 = new MyThreadTwo();
        
        for (int x = 1; x < 11; x++) {
            System.out.print(x + " ");
                
                if(x==5){
                    for(int i = 0; i < 10; i++){
                    System.out.print("A");
                    } 
                }
        }
    }
}
