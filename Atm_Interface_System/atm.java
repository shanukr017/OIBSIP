import java.util.ArrayList;
import java.util.Scanner;

class atm{
    static double balance = 0;
    static ArrayList<String> opn = new ArrayList<>();
    public static void main(String[] args) {
        int inp = 0;
        do{
            System.out.println("Select a Option To Continue");
            System.out.println("1 Deposit");
            System.out.println("2 Withdrawal");
            System.out.println("3 Transfer");
            System.out.println("4 Transaction history");
            System.out.println("5 Quit");
            Scanner mk = new Scanner(System.in);
            System.out.print("Enter a option: ");
            inp = mk.nextInt();
            atm_methods atms = new atm_methods();
            switch(inp){
                case 1:  
                    System.out.println();                  
                    System.out.print("Enter a amount to deposit: ");
                    Double amt1 = mk.nextDouble();
                    atms.deposit(amt1); 
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Enter a amount to withdrawal: ");
                    Double amt2 = mk.nextDouble();
                    atms.withdrawal(amt2); 
                    break;  
                case 3:
                    System.out.println();
                    System.out.print("Enter Name of Receiver : ");
                    String name = mk.next();
                    System.out.print("Enter a Account Number : ");
                    int acc =  mk.nextInt();
                    System.out.print("Enter a amount Transfer: ");
                    Double amt3 = mk.nextDouble();
                    atms.transfer(amt3,name,acc);
                    break; 
                case 4:
                    atms.history();
                    break;                                     
                default:
                    System.out.println();
                    if(inp == 5){
                        System.out.println("Logout Successfully");
                    }
                    else{
                        System.out.println();
                        System.out.println("Enter a valid option");
                    }
                    System.out.println();
                break;
            }
        }while(inp!=6);
    }
}

class atm_methods{
    
    void deposit(Double amount){
        atm.balance += amount;
        System.out.println();
        atm.opn.add("Deposit -> "+amount);
        System.out.println("Transaction Completed");
        System.out.println("Your balance is: "+atm.balance);
        System.out.println();

    }
    void withdrawal(Double amount){
        System.out.println();
        if(atm.balance-amount < 0){
            System.out.println("Transaction Completed");
            System.out.println("Your balance is not sufficient");
        }
        else{
            atm.balance -= amount;
            atm.opn.add("Withdrawal -> "+amount);
            System.out.println("Transaction Completed");
            System.out.println("Your balance is: "+atm.balance);
        }
        System.out.println();
    }
    void transfer(Double amount,String name,int acc){
        System.out.println();
        if(atm.balance-amount < 0){
            System.out.println("Transaction Completed");
            System.out.println("Your balance is not sufficient");
        }
        else{
            atm.opn.add("Transferred to "+name+" to accout no: "+acc+" amount -> "+amount);
            atm.balance -= amount;
            System.out.println("Transaction Completed");
            System.out.println("Money Transffered to "+name+" in account no: "+acc);
            System.out.println("Your balance is: "+atm.balance);
        }
        System.out.println();
    }
    void history(){
        System.out.println();
        System.out.println("Transaction history");

        if(atm.opn.size()==0){
            System.out.println("No Transaction in Account");
        }
        for(int i=0; i<atm.opn.size(); i++){
            System.out.println(atm.opn.get(i));
        }
        System.out.println();
    }
}
