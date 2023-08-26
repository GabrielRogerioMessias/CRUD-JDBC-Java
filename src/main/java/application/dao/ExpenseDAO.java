package application.dao;

import application.entities.Expense;
import application.entities.User;

public interface ExpenseDAO {
    public void insertExpense(Expense expense, User user);
    public void deleteExpense(int id);
    public void findAll();
    public void update(Expense expense);
    public void findByParts(String parts);
}
