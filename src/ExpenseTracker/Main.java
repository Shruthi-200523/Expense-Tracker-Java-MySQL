package ExpenseTracker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Total Expense");
            System.out.println("6. Category Report");
            System.out.println("7. Search Expense by Category");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();

                    dao.addExpense(amount, category, description, date);
                    break;

                case 2:
                    dao.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter Expense ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();

                    dao.updateExpense(updateId, newAmount);
                    break;

                case 4:
                    System.out.print("Enter Expense ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteExpense(deleteId);
                    break;

                case 5:
                    dao.totalExpense();
                    break;

                case 6:
                    dao.categoryReport();
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Enter Category: ");
                    String searchCategory = sc.nextLine();

                    dao.searchByCategory(searchCategory);
                    break;

                case 8:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}