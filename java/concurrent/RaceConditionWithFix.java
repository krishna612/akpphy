package concurrent;
import java.util.Random;

class DataSectionWithFix {
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    public void printer(){
        int i = 10000000;
        while(i!=0) {
            synchronized(this) {
                if(randInt%5 ==0) {
                    if(randInt%5 !=0) {
                        System.out.println(randInt);
                    }
                }
            }
            i--;
        }
    }

    public void modifier(){
        int i = 10000000;
        while(i!=0) {
            synchronized(this) {
                randInt = random.nextInt(10000);
                i--;
            }
        }
    }
}

public class RaceConditionWithFix {

    public static void main(String[] args) throws InterruptedException {
        DataSectionWithFix dataSection = new DataSectionWithFix();

        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable(){
            public void run() {
                dataSection.printer();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run() {
                dataSection.modifier();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        long timeTaken = end-start;
        System.out.println("Time taken for execution: "+timeTaken);
    }
}

