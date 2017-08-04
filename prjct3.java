/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_3;

import java.util.Scanner;

/**
 *
 * @author notebook
 */
abstract class Account
{
    double interestRate;
    double amount;
    abstract double calculateInterest();
}
class FDAccount extends Account
{
    double interest;
    double[][] rate={{4.50,5.00,6.50},{4.75,5.25,6.75},{5.50,6.00,6.75},{7,7.5,8},{7.50,8.00,8.50},{8.00,8.50,10.00}};
    int noOfDays,ageOfACHolder;
    FDAccount(double amt,int days,int age)
    {
        amount=amt;
        noOfDays=days;
        ageOfACHolder=age;
        
    }
    @Override
    double calculateInterest()
    {
        if(noOfDays<=14)
        {
            if(amount<10000000)
                interestRate=ageOfACHolder<60?rate[0][0]:rate[0][1];
            else
                interestRate=rate[0][2];
        }    
        else if(noOfDays<=29)
        {
            if(amount<10000000)
                interestRate=ageOfACHolder<60?rate[1][0]:rate[1][1];
            else
                interestRate=rate[1][2];
        }
        else if(noOfDays<=45)
        {
            if(amount<10000000)
                interestRate=ageOfACHolder<60?rate[2][0]:rate[2][1];
            else
                interestRate=rate[2][2];
        }
        else if(noOfDays<=60)
        {
            if(amount<10000000)
                interestRate=ageOfACHolder<60?rate[3][0]:rate[3][1];
            else
                interestRate=rate[3][2];
        }
        else if(noOfDays<=184)
        {
            if(amount<10000000)
                interestRate=ageOfACHolder<60?rate[4][0]:rate[4][1];
            else
                interestRate=rate[4][2];
        }
        else if(noOfDays<=366)
        {
            if(amount<10000000)
                interestRate=ageOfACHolder<60?rate[5][0]:rate[5][1];
            else
                interestRate=rate[5][2];
        }
        interest=amount-amount*interestRate;
        if(noOfDays>366)
            interest=0;
        return interest;
    }
    
    /*@Override
    double calculateInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
class SBAccount extends Account
{
    
    double interest;
    SBAccount(double amt,int ch)
    {
        amount=amt;
        interestRate=(ch==0)?4:6;
    }
    @Override
    double calculateInterest() {
        interest=amount-amount*interestRate;
        return interest;
    }
    
}
class RDAccount extends Account
{
    double interest;
    int noOfMonths,age;
    double monthlyAmount;
    double[][] rate={{7.50,8.00},{7.25,8.25},{8.00,8.50},{8.25,8.75},{8.50,9.00},{8.75,9.25}};
    
    RDAccount(double amt,int mon,int age)
    {
        monthlyAmount=amt;
        noOfMonths=mon; 
        this.age=age;
    }
   
    @Override
    double calculateInterest() {
        if(noOfMonths<=21)
        {
            interestRate=age<60?rate[noOfMonths/3-2][0]:rate[noOfMonths/3-2][1];
            interest=amount-amount*interestRate;
        }
        else
            interest=0;
        return interest;
      
    }
    
}
public class prjct3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double amt;
        int days,age,ch,ch1;
	  int flag=0;
        Scanner s=new Scanner(System.in);
        while(true)
	{
	System.out.println("Select the Option:\n\t1.Interest Calculator-SB\n\t2.Interest Calculator-FD\n\t3.Interest Calculator-RD\n\t4.Exit");
        ch=s.nextInt();
        System.out.println("Enter the Amount");
        amt=s.nextDouble();
        Account ac;
        switch(ch)
        {
            case 1:
                System.out.println("NRI ?(YES) 1 / (NO) 0");
                ch1=s.nextInt();
                ac=new SBAccount(amt,ch1);
		System.out.println("SBAccount INterest: ");
		System.out.print(ac.calculateInterest());
                break;
            case 2:
                System.out.println("Enter Age: ");
		age=s.nextInt();
		System.out.println("Enter Maturity period (in days): ");
		days=s.nextInt();
		ac=new FDAccount(amt,days,age);
		System.out.println("FDAccount INterest: ");
		System.out.print(ac.calculateInterest());
                break;
	    case 3:
		System.out.println("Enter Age: ");
		age=s.nextInt();
		System.out.println("Enter number of months: ");
		days=s.nextInt();
		ac=new RDAccount(amt,days,age);
		System.out.println("RDAccount INterest: ");
		System.out.print(ac.calculateInterest());
                break;
	    case 4:
		flag=1;
		break;
	    default:
		System.out.println("Invalid Choice");
	 }
	if(flag==1)
		break;
	}
    }
    
}
