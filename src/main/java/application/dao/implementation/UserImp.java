package application.dao.implementation;

import application.dao.UserDAO;
import application.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserImp implements UserDAO {
    private Connection connection;


    public UserImp() {
        try {
            String url = "jdbc:mysql://localhost/finance";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexão com o banco INICIADA!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertUser(User user) {
        PreparedStatement stmt;
        try {
            String query = "INSERT INTO USER (NAME, EMAIL,BALANCE) VALUES((?),(?),(?))";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setDouble(3, user.getBalance());
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("O usuario " + user.getName() + " foi inserido com sucesso!");
            } else {
                System.out.println("Error na inserção!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM USER WHERE ID = (?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("O usuário foi excluido com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void findAll() {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void findByParts(String parts) {

    }
}
