package application.entities;

public class Expense {
    private int id;
    private String description;
    private double valueExpense;
    private int id_user;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValueExpense() {
        return valueExpense;
    }

    public void setValueExpense(double valueExpense) {
        this.valueExpense = valueExpense;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense expense)) return false;

        return getId() == expense.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
