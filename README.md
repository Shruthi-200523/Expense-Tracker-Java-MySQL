# Expense Tracker (Java + MySQL)

A console-based Expense Tracker application developed using Java, JDBC, and MySQL.

## Features
* Add Expense
* View Expenses
* Update Expense
* Delete Expense
* Total Expense Report
* Category-wise Report
* Search Expense by Category

## Technologies Used
* Java
* JDBC
* MySQL
* IntelliJ IDEA

## Database Schema
```sql
CREATE TABLE expenses(
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    category VARCHAR(50),
    description VARCHAR(100),
    expense_date DATE
);
```
## How to Run
1. Clone the repository.
2. Create the `expense_tracker` database in MySQL.
3. Update the database username and password in `DatabaseConnection.java`.
4. Run `Main.java`.

## Author
Nayakavadi Shruthi
