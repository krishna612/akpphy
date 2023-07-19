package concurrent;

import java.util.Random;

class DataSection{
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    public void printer(){
        int i = 1000000;
        while(i!=0) {
            if(randInt%5 ==0) {
                if(randInt%5 !=0) {
                    System.out.println(randInt);
                }
            }
            i--;
        }
    }

    public void modifier(){
        int i = 1000000;
        while(i!=0) {
            randInt = random.nextInt(100000);
            i--;
        }
    }
}

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        DataSection dataSection = new DataSection();

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
    }
}

