import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        String userId = "147852";
        String userPin = "8795";
        Account account = new Account(userId, userPin);

        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;

        System.out.println("Welcome to the ATM");
        while (!isAuthenticated) {
            System.out.print("Enter User ID: ");
            String inputUserId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String inputPin = scanner.nextLine();

            if (account.validateCredentials(inputUserId, inputPin)) {
                isAuthenticated = true;
            } else {
                System.out.println("Invalid User ID or PIN. Please try again.");
            }
        }

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's user id: ");
                    String recipientUserId = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    Account recipientAccount = new Account(recipientUserId, "");
                    account.transfer(recipientAccount, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
