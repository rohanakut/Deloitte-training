import java.util.Scanner;

public class Marks {

    public static void main(String[] args) {
        int marks=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Marks");
        marks=sc.nextInt();

        if (marks>=90) {
            System.out.println("Grade A");
        } else if(marks<90 && marks>=70) {
            System.out.println("Grade B");
        }
        else{
            System.out.println("Grade C");
        }
    }
}