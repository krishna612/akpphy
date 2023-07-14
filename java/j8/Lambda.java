package j8;

@FunctionalInterface
interface Greeting{
   void greet();
}

public class Lambda {

    public static void wish(Greeting greeting){
        greeting.greet();
    }
    public static void main(String[] args){
        wish(()->System.out.println("Namaste"));
        wish(()->System.out.println("Good Morning"));
    }
}
