package application.dao;

import application.entities.Expense;
import application.entities.User;

import java.util.List;

public interface ExpenseDAO {
    public void insertExpense(Expense expense, User user);
    public void deleteExpense(int id);
    public List<Expense> findAll();
    public void update(Expense expense,int id);

}
