package atmapplication;

import java.util.*;

public class AtmApplication {
    
    static Scanner scan = new Scanner(System.in);
    
    public static String checkID(String accNum, String passwd){
        String result = "error";
        
        String a = "ref983-55 p@ssw0rd 876.87";
        String b = "ref3421-77 Myp@sswd 7777.01";
        String c = "ref23-91 Thep@ssw0rd 98.99";
        
        if(accNum.equals(a.substring(0, a.indexOf(" "))) && 
                passwd.equals(a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" ")))){
            return result = a.substring(a.lastIndexOf(" ") + 1);
        } else if (accNum.equals(b.substring(0, b.indexOf(" "))) &&
                passwd.equals(b.substring(b.indexOf(" ") + 1, b.lastIndexOf(" ")))){
            return result = b.substring(b.lastIndexOf(" ") + 1);
        }
        else if (accNum.equals(c.substring(0, c.indexOf(" "))) && 
                passwd.equals(c.substring(c.indexOf(" ") + 1, c.lastIndexOf(" ")))){
            return result = c.substring(b.lastIndexOf(" ") + 1);
        }
        
        return result;
    }

    public static int menu(){
        int menuChoice;
        do{
            System.out.println("WELECOME TO HOME BANK");
            System.out.println("Please choose one of the following");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            
            menuChoice = scan.nextInt();
            
            if (menuChoice < 1 || menuChoice > 4){
                System.out.print("error");
            }
        }while (menuChoice < 1 || menuChoice > 4);
                return menuChoice;
        }
    
    public static double deposit(double depAmount, double curAmount){
        double depositAmount = depAmount, currentAmount = curAmount;
        double newBalance = depositAmount + currentAmount;
        
        System.out.printf("Your new balance is kes%.2f\n:", newBalance);
        
        return newBalance;
    }
    
    public static double withdraw(double withAmount, double curAmount){
        double withdrawAmount = withAmount, currentAmount = curAmount;
        double newBalance =  currentAmount-withdrawAmount;
        
        System.out.printf("Your new balance is kes%.2f\n:", newBalance);
        
        return newBalance;
    }
    
    public static void displayBalance(double amount){
        System.out.printf("Your balance is kes%.2f\n:", amount);
    }
    
    public static void main(String[] args) {
        String accNum, passwd, origBalance = "error";
        int count = 0, menuOption = 0;
        double depositAmount = 0, withdrawAmount = 0, currentBalance = 0;
        boolean foundNonDigit;
        
        do{
            foundNonDigit = false;
            System.out.println("Enter your Account Number:");
            accNum = scan.next();
            
            System.out.println("Enter Your Password:");
            passwd = scan.next();
            
            origBalance = checkID(accNum, passwd);
            count++;
            
            if (count >=3 && origBalance.equals("error")) {
                System.out.println("Maximum Number of tries reached. Please visit Customer Care for assistence");
                System.exit(0);
            }else{
                System.out.println(origBalance);
            }
        }while(origBalance.equals("error"));
        
        currentBalance = Double.parseDouble(origBalance);
        
        while(menuOption != 4){
            menuOption = menu();
            switch (menuOption){
                case 1:
                    displayBalance(currentBalance);
                    break;
                case 2:
                    System.out.println("Enter Amount You wish to deposit: kes");
                    depositAmount = scan.nextDouble();
                    currentBalance = deposit(depositAmount, currentBalance);
                    break;
                case 3:
                    System.out.println("Enter Amount You wish to withdraw: kes");
                    withdrawAmount = scan.nextDouble();
                    while(withdrawAmount > currentBalance){
                        System.out.println("SORRY ISSUFICIENT FUNDS!!! PLEASE ENTER DIFFERENT AMOUNT.");
                        withdrawAmount = scan.nextDouble();
                    }
                    currentBalance = withdraw(withdrawAmount, currentBalance);
                    break;
                case 4:
                    System.out.println("Thank You for banking with us. Have a nice day. Good-bye");
                    System.exit(0);
                    break;
            }
        }
    }
    
}
