import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime dateAndTime;
    private double clearBalance;

    public Transaction(String type, double amount , LocalDateTime dateAndTime, double clearBalance) {
        this.type = type;
        this.amount = amount;
        this.dateAndTime = dateAndTime;
        this.clearBalance = clearBalance;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
    public LocalDateTime getDateAndTime()
    {
        return dateAndTime;
    }
    public double getClearBalance()
    {
        return clearBalance;
    }
}
