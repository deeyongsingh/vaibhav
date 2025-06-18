package bankaccount;

public class BankAccount {
    String accountHolderName;
    int  accountNumber;
    double balance;
    BankAccount(String accountHolderName,int accountNumber,double initialBalance){
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
    }
    void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposited: ₹"+amount);
        }else{
            System.out.println("invalid deposit amount.");
        }
    }
    void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw: ₹"+amount);
        }
        else{
            System.out.println("invalid Withdraw amount.");
        }
    }
    void display(){
        System.out.println("Account Holder Name:" +accountHolderName);
        System.out.println("Account NO:"+accountNumber);
    }
void displaybalance(){
    System.out.println("Current Balance: ₹" +balance);
}
public static void main(String[]args){
        BankAccount account = new BankAccount("Anshu raj",123456789,10000);
        account.display();
        account.displaybalance();
        account.deposit(1000);
        account.withdraw(3000);
        account.displaybalance();
}
}
