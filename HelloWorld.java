public class HelloWorld{

    public static void main(String[] args) {
            System.out.println("Hello");
            Greeting g = new Greeting();
            g.greet();
    }

}

class Greeting{
    public void greet() {
        System.out.println("Hello from Greeting");

    }
}