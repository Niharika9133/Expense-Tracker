import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
    private List<Transaction> transactions = new ArrayList<>();

    public void addIncome(double amount, String category, LocalDate date) {
        transactions.add(new Transaction(amount, category, date));
    }

    public void addExpense(double amount, String category, LocalDate date) {
        transactions.add(new Transaction(-amount, category, date));
    }

    public void viewAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("Date       | Category | Amount");
        System.out.println("------------------------------");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Transaction t : transactions) {
                writer.write(t.getAmount() + "," + t.getCategory() + "," + t.getDate());
                writer.newLine();
            }
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile(String filename) {
        transactions.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                LocalDate date = LocalDate.parse(parts[2]);
                transactions.add(new Transaction(amount, category, date));
            }
            System.out.println("Data loaded.");
        } catch (IOException e) {
            System.out.println("No previous data found, starting fresh.");
        }
    }
}