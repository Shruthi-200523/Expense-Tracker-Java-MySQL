package ExpenseTracker;

public class Expense {

    private int expenseId;
    private double amount;
    private String category;
    private String description;
    private String expenseDate;

    public Expense() {
    }
    public Expense(double amount, String category, String description, String expenseDate) {

        this.amount = amount;
        this.category = category;
        this.description = description;
        this.expenseDate = expenseDate;
    }
    public int getExpenseId() {
        return expenseId;
    }
    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getExpenseDate() {
        return expenseDate;
    }
    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }
}



