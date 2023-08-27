package application.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private double balance;
    List<Expense> expenseList = new ArrayList<>();

    public User() {
    }
    public User( int id, String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public User( String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
