package application.dao;

import application.entities.User;

import java.util.List;

public interface UserDAO {

    public void insertUser(User user);
    public void deleteUser(int id);
    public List<User> findAll();
    public void updateByID(User user,int id);


}
