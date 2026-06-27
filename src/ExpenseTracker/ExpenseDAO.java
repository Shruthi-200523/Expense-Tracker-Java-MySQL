package ExpenseTracker;
import java.sql.*;

public class ExpenseDAO {

    // Add Expense
    public void addExpense(double amount, String category, String description, String date) throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "INSERT INTO expenses(amount,category,description,expense_date) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, amount);
        ps.setString(2, category);
        ps.setString(3, description);
        ps.setString(4, date);

        ps.executeUpdate();
        System.out.println("Expense Added Successfully!");
        con.close();
    }

    // View Expenses
    public void viewExpenses() throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM expenses";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println();
        System.out.println("ID\tAmount\tCategory\tDescription\tDate");
        System.out.println("-----------------------------------------------------");

        while (rs.next()) {
            System.out.println(rs.getInt("expense_id")
                            + "\t"
                            + rs.getDouble("amount")
                            + "\t"
                            + rs.getString("category")
                            + "\t\t"
                            + rs.getString("description")
                            + "\t\t"
                            + rs.getDate("expense_date")
            );
        }
        con.close();
    }

    // Update Expense
    public void updateExpense(int id, double amount) throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "UPDATE expenses SET amount=? WHERE expense_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, amount);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Expense Updated!");
        else
            System.out.println("Expense ID Not Found!");

        con.close();
    }

    // Delete Expense
    public void deleteExpense(int id) throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "DELETE FROM expenses WHERE expense_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Expense Deleted!");
        else
            System.out.println("Expense ID Not Found!");

        con.close();
    }

    // Total Expense
    public void totalExpense() throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "SELECT SUM(amount) AS total FROM expenses";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Total Expense: ₹" + rs.getDouble("total"));
        }
        con.close();
    }

    // Category Report
    public void categoryReport() throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "SELECT category, SUM(amount) AS total " + "FROM expenses GROUP BY category";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\nCategory\tTotal");
        System.out.println("------------------------");

        while (rs.next()) {
            System.out.println(rs.getString("category")
                            + "\t\t₹"
                            + rs.getDouble("total"));
        }
        con.close();
    }

    // Search by Category
    public void searchByCategory(String category) throws Exception {

        Connection con = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM expenses WHERE category=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, category);
        ResultSet rs = ps.executeQuery();

        System.out.println("\nID\tAmount\tDescription\tDate");
        System.out.println("----------------------------------");

        while (rs.next()) {
            System.out.println(rs.getInt("expense_id")
                            + "\t"
                            + rs.getDouble("amount")
                            + "\t"
                            + rs.getString("description")
                            + "\t"
                            + rs.getDate("expense_date"));
        }
        con.close();
    }
}