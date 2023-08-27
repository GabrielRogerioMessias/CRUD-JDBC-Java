package application.dao.implementation;

import application.dao.UserDAO;
import application.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImp implements UserDAO {
    private Connection connection;


    public UserImp() {
        try {
            String url = "jdbc:mysql://localhost/finance";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexão eniciada.");
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
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM USER";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double balance = rs.getDouble("balance");
                User u = new User(id, name, email, balance);
                list.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void updateByID(User user, int id) {
        String query = "UPDATE USER SET NAME = (?), EMAIL = (?) WHERE ID = (?) ";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Update executado com sucesso!");
            } else {
                System.out.println("Houve um erro com o update, verifique o usuário");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
