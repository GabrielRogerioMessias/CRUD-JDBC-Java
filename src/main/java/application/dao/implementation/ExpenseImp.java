package application.dao.implementation;

import application.dao.ExpenseDAO;
import application.entities.Expense;
import application.entities.User;
import com.sun.source.tree.TryTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseImp implements ExpenseDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public ExpenseImp() {
        try {
            String url = "jdbc:mysql://localhost/finance";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            if (connection == null) {
                System.out.println("Error na conexão da classe Expense");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insertExpense(Expense expense, User user) {
        String query = "INSERT INTO EXPENSE (DESCRIPTION,VALUEEXPENSE,ID_USER) VALUES((?)(?)(?))";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, expense.getDescription());
            stmt.setDouble(2, expense.getValueExpense());
            stmt.setInt(3, user.getId());
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Expense incluida com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExpense(int id) {
        String query = "DELETE FROM EXPENSE WHERE ID = (?)";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Expense excluida com sucesso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> findAll() {
        List<Expense> list = new ArrayList<>();
        String query = "SELECT * FROM EXPENSE";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                double valueexpense = rs.getDouble("valueexpense");
                int id_user = rs.getInt("id_user");
                Expense exp = new Expense();
                list.add(exp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Expense expense, int id) {
        String query = "UPDATE FROM EXPENSE SET DESCRIPTION=(?), VALUEEXPENSE=(?) WHERE id = (?) ";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, expense.getDescription());
            stmt.setDouble(2, expense.getValueExpense());
            stmt.setInt(3, expense.getId());
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Update realizado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
