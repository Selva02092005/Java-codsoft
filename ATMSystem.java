import java.util.*;
public class ATMSystem {
    static class BankAccount {
        private double balance;
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        public double getBalance() {
            return balance;
        }
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount must be greater than 0.");
            }
        }
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            } else if (amount <= 0) {
                System.out.println("Withdrawal amount must be greater than 0.");
            } else {
                System.out.println("Insufficient balance for this withdrawal.");
            }
            return false;
        }
    }
    static class ATM {
        private BankAccount account;
        public ATM(BankAccount account) {
            this.account = account;
        }
        public void withdraw(double amount) {
            if (account.withdraw(amount)) {
                System.out.println("You have successfully withdrawn " + amount);
            }
        }
        public void deposit(double amount) {
            account.deposit(amount);
            System.out.println("You have successfully deposited " + amount);
        }
        public void checkBalance() {
            System.out.println("Your current balance is: " + account.getBalance());
        }
        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");

                System.out.print("Select an option (1-4): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
		    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
