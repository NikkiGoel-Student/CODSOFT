import java.util.*;

// ATM class that handles all ATM operations
class ATM {
    private float balance = 0; // Initial account balance
    private int PIN = 1722; // Default PIN
    private List<String> transactionHistory = new ArrayList<>(); // List to store transaction history
    private Scanner sc = new Scanner(System.in); // Scanner for user input

    // Method to handle PIN verification
    public void pin_func() {
        System.out.println("Enter your PIN(4 digits): ");
        int en_pin = sc.nextInt();
        if (PIN == en_pin) {
            menu(); // Show menu if PIN is correct
        } else {
            System.out.println("Invalid PIN. Try again.");
            pin_func(); // Retry PIN input if incorrect
        }
    }

    // Method to display the menu and handle user choices
    public void menu() {
        System.out.println("1. Check a/c balance");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Change PIN");
        System.out.println("5. View transaction history");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                checkBalance(); // Check account balance
                break;
            case 2:
                depositMoney(); // Deposit money
                break;
            case 3:
                withdrawMoney(); // Withdraw money
                break;
            case 4:
                changePIN(); // Change PIN
                break;
            case 5:
                viewTransactionHistory(); // View transaction history
                break;
            case 6:
                System.exit(0); // Exit the program
            default:
                System.out.println("Please enter a valid choice!");
                menu(); // Show menu again for invalid choice
        }
    }

    // Method to check and display account balance
    public void checkBalance() {
        System.out.println("Account balance is: " + balance);
        transactionHistory.add("Checked balance: " + balance);
        menu(); // Return to menu after displaying balance
    }

    // Method to handle money withdrawal
    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw: ");
        int amount = sc.nextInt();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            transactionHistory.add("Failed withdrawal attempt: " + amount);
        } else {
            balance -= amount;
            System.out.println("Money withdrawn successfully.");
            transactionHistory.add("Withdrawn: " + amount + ", Remaining balance: " + balance);
        }
        menu(); // Return to menu after withdrawal
    }

    // Method to handle money deposit
    public void depositMoney() {
        System.out.println("Enter the amount to deposit: ");
        int amount = sc.nextInt();
        balance += amount;
        System.out.println("Amount deposited successfully.");
        transactionHistory.add("Deposited: " + amount + ", New balance: " + balance);
        menu(); // Return to menu after deposit
    }

    // Method to handle PIN change
    public void changePIN() {
        System.out.println("Enter your current PIN: ");
        int currentPIN = sc.nextInt();
        if (currentPIN == PIN) {
            System.out.println("Enter new PIN: ");
            int newPIN = sc.nextInt();
            PIN = newPIN;
            System.out.println("PIN changed successfully.");
            transactionHistory.add("PIN changed successfully.");
        } else {
            System.out.println("Incorrect current PIN.");
            transactionHistory.add("Failed PIN change attempt.");
        }
        menu(); // Return to menu after attempting to change PIN
    }

    // Method to display transaction history
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        menu(); // Return to menu after displaying transaction history
    }
}

// Main class to run the ATM program
public class Task_3_Atm_Machine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.pin_func(); // Start the ATM operations with PIN verification
    }
}
