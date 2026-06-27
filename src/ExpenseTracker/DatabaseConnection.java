
package ExpenseTracker;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/expense_tracker";
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(url, user, password);
    }
}
