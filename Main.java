import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);
        String filename = "data.txt";

        // Auto-load data at start
        tracker.loadFromFile(filename);

        while (true) {
            System.out.println("\n1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. Save Data");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter income amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.nextLine();
                System.out.print("Enter date (YYYY-MM-DD): ");
                String dateStr = sc.nextLine();
                LocalDate date = LocalDate.parse(dateStr);
                tracker.addIncome(amount, category, date);
                System.out.println("Income added.");
            } else if (choice == 2) {
                System.out.print("Enter expense amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.nextLine();
                System.out.print("Enter date (YYYY-MM-DD): ");
                String dateStr = sc.nextLine();
                LocalDate date = LocalDate.parse(dateStr);
                tracker.addExpense(amount, category, date);
                System.out.println("Expense added.");
            } else if (choice == 3) {
                tracker.viewAllTransactions();
            } else if (choice == 4) {
                tracker.saveToFile(filename);
            } else if (choice == 5) {
                tracker.saveToFile(filename);
                System.out.println("Data saved. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}