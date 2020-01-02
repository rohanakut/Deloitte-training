// Name Chinmay Pophale

import java.util.*;
public class ReverseString{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        char ch;
		System.out.println("Enter a string");
        String str = sc.nextLine();
        System.out.print(" The String in Reverse Order is:  ");
        // String inLC = str.toLowerCase();
        for (int i = str.length()-1; i >= 0; i--) {
            ch=str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
            System.out.print(ch);
        }
        System.out.println("    The No of Vowels are :" +count);
    }

}

