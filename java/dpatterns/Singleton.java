package patterns;
//https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
public class Singleton {
	private volatile static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized(Singleton.class) {
				if(instance==null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
