package application.app;

import application.dao.UserDAO;
import application.dao.implementation.UserImp;
import application.entities.User;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        UserImp userImp =  new UserImp();
//        User u = new User("Gabriel Messias","Gamessiasjt@gmail.com",0);
        userImp.deleteUser(2);



    }
}
