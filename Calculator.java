import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        // c.calculate();
        c.largest();
    }

    public void largest() {
        Scanner sc = new Scanner(System.in);
        int largestNo, n1,n2,n3;

        System.out.println("Enter 3 Nos");
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();

        if (n1>n2 && n1>n3) {
            largestNo=n1;
        } else if(n2>n1 && n2>n3) {
            largestNo=n2;
        }else{
            largestNo=n3;
        }

        System.out.println("The Largest No is "+largestNo);
    }

    public void calculate() {
        Scanner sc = new Scanner(System.in);
        int choice, n1,n2;
        double result = 0;

        System.out.println("Enter the choice for operation 1 + , 2 -, 3 *, 4 /");
        choice = sc.nextInt();
        System.out.println("Enter two nos");
        n1 = sc.nextInt();
        n2 = sc.nextInt();

        if (choice ==1) {
            result = n1+n2;
        } else if(choice == 2){
            result = n1-n2;
        }else if(choice == 3){
            result = n1*n2;
        }else if(choice == 4){
            result = n1/n2;
        }else{
            System.out.println("Enter correct no");
        }

        System.out.println("Result is "+result);
 
    }
}