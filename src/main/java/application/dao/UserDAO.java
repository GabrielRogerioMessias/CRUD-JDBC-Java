package application.dao;

import application.entities.User;

public interface UserDAO {

    public void insertUser(User user);
    public void deleteUser(int id);
    public void findAll();
    public void update(User user);
    public void findByParts(String parts);

}
