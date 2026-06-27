CREATE DATABASE expense_tracker;
USE expense_tracker;
CREATE TABLE expenses(
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    category VARCHAR(50),
    description VARCHAR(100),
    expense_date DATE
);
