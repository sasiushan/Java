// package com.simpleatm.app;


import java.util.Scanner;
import java.io.IOException;

public class ATM_Program {
   
    private double balance;
    private  double totalWithdrawAmount;
    private  double totalDepositAmount;  
    private  int depositCount;
    private  int withdrawCount;
    private final  int MAX_DEPOSIT_FREQUENCY = 4;    
    private final double MAX_DEPOSIT_PER_DAY = 150000.00;
    private final double MAX_DEPOSIT_PER_TRANSACTION = 40000.00;

    private final double MAX_WITHDRAWAL_PER_DAY = 50000.00;
    private final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000.00;
    private final int MAX_WITHDRAWAL_FREQUENCY = 3;

    public static Scanner input = new Scanner(System.in);    

    public ATM_Program(){
    	     balance = 0.00;
             totalWithdrawAmount = 0.00;
             totalDepositAmount = 0.00;  
             depositCount = 0;
             withdrawCount = 0;
    }

    public String toString() {
        return "Current Balance:" + balance;
    }

        public  double getBalance(){
         
         System.out.printf("\nCurrent Balance:%.2f\n",balance);
         
         return balance;
     }

       public double getTotalWithdrawals(){    

        System.out.printf("\nTotal Withdrawals:%.2f\n",totalWithdrawAmount);

        return totalWithdrawAmount;

       }
       public  double getTotalDeposits(){ 

       	System.out.printf("\nTotal Deposits:%.2f\n",totalDepositAmount);

       	return totalDepositAmount;
       }


    
       public double deposit(double amount) throws IOException,Exception{    
       //amount should be greater than 0 &&
       //amount should be less than	40,000 &&
       //deposit count should be less that 3
        if (amount > 0.00 && amount <= MAX_DEPOSIT_PER_TRANSACTION && depositCount < MAX_DEPOSIT_FREQUENCY) 
        {

        	depositCount++;        	          
            
        } else {

        	throw new IOException();
        }

        totalDepositAmount = totalDepositAmount + amount;       

        if(totalDepositAmount <= MAX_DEPOSIT_PER_DAY){

            
            balance = balance  + amount;   


        } else {


        	throw new Exception();
        }
        
        return balance;  
     
    }

    
      public double withdraw(double amount) throws IOException,Exception 
      {
        if (amount > 0.00 && amount < balance && withdrawCount < MAX_WITHDRAWAL_FREQUENCY && amount <= MAX_WITHDRAWAL_PER_TRANSACTION)
        {
            
             withdrawCount++; 
                                  
        }
         else 
        {

        	throw new IOException();
        }

        totalWithdrawAmount = totalWithdrawAmount + amount;

        if(totalWithdrawAmount <= MAX_WITHDRAWAL_PER_DAY)
        {

        	balance = balance - amount;        	

        } else 
        {

        	throw new Exception();
        }

        return balance;            
    }

    public static void main(String[] args)
    {

           ATM_Program account = new ATM_Program();           

          do{

           int menuOption;
           boolean continueInput = true;

            System.out.println("************************************************");
            System.out.println("1.Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Quit");
            System.out.println("************************************************");
            System.out.print("Enter Menu Option(and press Enter):");
            
            while(!input.hasNext())
            {
                input.next();
            }
            menuOption = input.nextInt();
            
            switch(menuOption)
            {
            //Balance
            case 1:
                System.out.println("BALANCE");
                System.out.println(account.toString());
                  break;
            //Deposit	  
            case 2:

                try {
                    System.out.println("DEPOSIT");
                    System.out.println(account.toString()); 
                    System.out.print("Enter deposit amount:");

                    while(!input.hasNextDouble())
                    {
                         input.next();
                         
                     }                       
                    double amountToDeposit = input.nextDouble();
                    continueInput = false;

                    account.deposit(amountToDeposit);
                    System.out.println("Deposit Count: "+account.depositCount);
                    System.out.println(account.toString());

                    } catch (IOException ex){

                   System.out.printf("Error:Check either your Input(negative number),Max Deposit Per Transaction(40K),Max.Deposit Frequency(4)\n",ex.getMessage());
                    }
                     catch (Exception ex){
                        
                       System.out.printf("Maximum Deposit Per Day Reached\n",ex.getMessage()); 

                     }                                                             
                
                   break;
            //Withdraw	
            case 3:
                  try {  
                    System.out.println("WITHDRAWAL");
                    System.out.println(account.toString());
                    System.out.print("Enter withdraw amount:");
                       
                     while(!input.hasNextDouble()){
                         input.next();
                         
                     }
                     double amountToWithdraw = input.nextDouble();                
                     account.withdraw(amountToWithdraw);
                     System.out.println("Withdraw Count: "+account.withdrawCount);
                     System.out.println(account.toString());
                       } catch(Exception e){

                  	System.out.printf("Exception in Withdraw\n",e.getMessage());
                  }
                                   
                break;                  
            //Quit
            case 4:
                try {
                 System.out.print("Are you sure you want to QUIT?(y/n)");
                 if(input.next().equals("y")){
                     System.exit(0);					 
                    }
                } catch (Exception ex){
                
                    System.out.printf("Exception in Quit",ex.getMessage());
                }
                    break;   
                     
            default:
                    System.out.println("Invalid Menu Option");
                     	 
                     }
                 } while(true);
             }
       

    }

   


    


