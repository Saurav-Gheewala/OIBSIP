import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userId;
    private String userPin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validateCredentials(String userId, String userPin) {
        return this.userId.equals(userId) && this.userPin.equals(userPin);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit " , amount , LocalDateTime.now(),balance));

        System.out.println("Deposit successful. Your Current balance Is: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount ,LocalDateTime.now(),balance));
            System.out.println("Withdrawal successful. Your Current balance Is: " + balance);
        } else {
            System.out.println("Error! Insufficient funds.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("Transfer", amount, LocalDateTime.now(),balance));
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Error! Insufficient funds.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("");
        System.out.println("Your Transaction history:");
        System.out.println("Transaction Type          Transaction Ammount          Clear Balance          Transaction Time");
        System.out.println("");
        for (Transaction transaction : transactionHistory) {
            if(transaction.getType() == "Withdrawal")
                System.out.println(transaction.getType() + "                " + transaction.getAmount() + "                       "+ transaction.getClearBalance() +"                 " + transaction.getDateAndTime());
            else
                System.out.println(transaction.getType() + "                  " + transaction.getAmount() + "                       "+ transaction.getClearBalance() +"                 " + transaction.getDateAndTime());
        }
    }
}
