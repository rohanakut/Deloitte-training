import java.util.Scanner;

public class EMICalc {

    double dp,interest,amount, rate, time;

    EMICalc( double amount,double rate, double time,double dp){
        this.amount=amount;
        this.rate=rate;
        this.time=time;
        this.dp=dp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount,rate,time,dp;
        amount = sc.nextDouble();
        rate = sc.nextDouble();
        time = sc.nextDouble();
        dp = sc.nextDouble();
        EMICalc e = new EMICalc(amount, rate, time,dp);
        e.calcEMI();
    }

    public void calcEMI() {
        
        // System.out.println("Enter the amount ");
        interest = (amount-dp)*rate*time/100;

        System.out.println("Monthly EMI is "+(amount-dp+interest)/12);
         
    }

}