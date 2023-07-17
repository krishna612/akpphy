package patterns;

public class SingletonTest {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
				    public void run() {
				    	System.out.println("in thread1: "+Singleton.getInstance());
				    }
		        });
		Thread t2 = new Thread(new Runnable() {
		    public void run() {
		    	System.out.println("in thread1: "+Singleton.getInstance());
		    }
        });
		Thread t3 = new Thread(new Runnable() {
		    public void run() {
		    	System.out.println("in thread1: "+Singleton.getInstance());
		    }
        });
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		
	}

}
