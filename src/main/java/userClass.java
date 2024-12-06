import java.util.ArrayList;

public class userClass {
    private String name;
    private double accountBalance;
    private double monthlyBudget;
    private ArrayList<itemClass> individualItems;
    private ArrayList<sharedItemClass> sharedItems;
    private boolean hasConfirmed;
    private String password; // New field for the user's password

    // Updated constructor to include password
    public userClass(String name, double accountBalance, double monthlyBudget, String password) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.monthlyBudget = monthlyBudget;
        this.password = password;
        // Initialize the item lists if needed
        this.individualItems = new ArrayList<>();
        this.sharedItems = new ArrayList<>();
        this.hasConfirmed = false; // default value
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public ArrayList<itemClass> getIndividualItems() {
        return individualItems;
    }

    public void setIndividualItems(ArrayList<itemClass> individualItems) {
        this.individualItems = individualItems;
    }

    public ArrayList<sharedItemClass> getSharedItems() {
        return sharedItems;
    }

    public void setSharedItems(ArrayList<sharedItemClass> sharedItems) {
        this.sharedItems = sharedItems;
    }

    public boolean isHasConfirmed() {
        return hasConfirmed;
    }

    public void setHasConfirmed(boolean hasConfirmed) {
        this.hasConfirmed = hasConfirmed;
    }

    // New getters and setters for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
