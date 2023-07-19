package concurrent;
import java.util.concurrent.atomic.AtomicInteger;

interface CounterInterface{
    public void increment();
    public void decrement();
    public void printCounter();
}

class ECounter implements CounterInterface{
    private int counter;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public void printCounter() {
        System.out.println("counter val: "+this.counter);
    }
}

class CounterFixSync implements CounterInterface{
    private int counter;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public void setCounter(int val) {
        this.counter = val;
    }

    public void printCounter() {
        System.out.println("counter val: "+this.counter);
    }
}

class CounterFixAtomic implements CounterInterface{
    //exploer how AtomicInteger works, internally saw it's using some unsafe class
    //https://www.baeldung.com/java-unsafe
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public void printCounter() {
        System.out.println("counter val: "+this.counter);
    }
}

class IncrementTask implements Runnable{
    private CounterInterface count;

    public IncrementTask(CounterInterface count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;i++) {
            this.count.increment();
            /*try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/
        }
    }

}

class DecrementTask implements Runnable{
    private CounterInterface count;

    public DecrementTask(CounterInterface count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;i++) {
            this.count.decrement();
            /*try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/
        }
    }

}

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {
        ECounter counter = new ECounter();
        System.out.println("*** Before stating, with out Synchronized fix or Atomic Fix  ****");
        long start = System.currentTimeMillis();
        counter.printCounter();
        IncrementTask task1 = new IncrementTask(counter);
        DecrementTask task2 = new DecrementTask(counter);
        Thread t1			= new Thread(task1);
        Thread t2			= new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        long timeTaken = end-start;
        System.out.println("time take for itr1: "+timeTaken);
        System.out.println("**** Value At the end for itr1, you don't see 0 if you run multiple times  ****");
        counter.printCounter();

        System.out.println();
        System.out.println("itr2: with synchronized fix, should take more time");
        start = System.currentTimeMillis();
        CounterFixSync counterSync = new CounterFixSync();
        IncrementTask task3 = new IncrementTask(counterSync);
        DecrementTask task4 = new DecrementTask(counterSync);
        Thread t3			= new Thread(task3);
        Thread t4			= new Thread(task4);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        end = System.currentTimeMillis();
        timeTaken = end-start;
        System.out.println("time take for itr2: "+timeTaken);
        System.out.println("**** Value At the end for itr1, you shoud see 0 always  ****");
        counterSync.printCounter();

        System.out.println();
        System.out.println("itr3: with AtomicInteger fix, should take less time compared to sync fix in itr2");
        start = System.currentTimeMillis();
        CounterFixAtomic counterAtomic = new CounterFixAtomic();
        IncrementTask task5 = new IncrementTask(counterAtomic);
        DecrementTask task6 = new DecrementTask(counterAtomic);
        Thread t5			= new Thread(task5);
        Thread t6			= new Thread(task6);
        t5.start();
        t6.start();
        t5.join();
        t6.join();
        end = System.currentTimeMillis();
        timeTaken = end-start;
        System.out.println("time take for itr3: "+timeTaken);
        System.out.println("**** Value At the end for itr1, you shoud see 0 always  ****");
        counterAtomic.printCounter();

    }
}

