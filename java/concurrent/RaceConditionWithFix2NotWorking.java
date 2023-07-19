package concurrent;

/* TBD, what I a m thinking is not working with this AtomicInteger
 * Need to use synchronized only
 *
 */
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class DataSectionFix2{
    AtomicInteger randInt = new AtomicInteger(0);
    Random random = new Random(System.currentTimeMillis());

    public void printer(){
        int i = 10000000,tmp=0;
        while(i!=0) {

            if(randInt.get()%5 ==0) {
                if(randInt.get()%5 !=0) {
                    System.out.println(randInt);
                }
            }
            i--;
        }
    }

    public void modifier(){
        int i = 10000000;
        while(i!=0) {
            int existingValue = randInt.get();
            randInt.compareAndSet(existingValue,random.nextInt(100000));
            i--;
        }
    }
}

public class RaceConditionWithFix2NotWorking {

    public static void main(String[] args) throws InterruptedException {
        DataSectionFix2 dataSection = new DataSectionFix2();

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

