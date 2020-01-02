import java.util.Scanner;

public class SumPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int g,l;
        if (n1>n2) {
            g=n1;
            l=n2;            
        }
        else{
            g=n2;
            l=n1;
        }
        int sum=0,count=0,i=2;

        while (l<=g) {
            while (i<l) {
                if (l%i==0) {
                    count++;
                }
                i++;
            }
            if (count==0) {
                sum+=l;
            }
            i=2;
            count=0;
            l++;
        }

        System.out.println("Sum of Pime Nos is :"+sum);
    }
}