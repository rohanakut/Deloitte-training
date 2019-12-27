import java.util.Scanner;
public class first{
    public static void main(String[] args)
    {
        Scanner sys = new Scanner(System.in);
        int a = sys.nextInt();
        int b = sys.nextInt();
        int c = sys.nextInt();

     Calculator d  = new Calculator();
     d.find(a);
     
    }
    
}
class Calculator{
    public void find(int a)
    {
        for(int i=0;i<=10;i++)
        System.out.println(a*i);
    }
}