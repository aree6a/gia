
import java.util.ArrayList;


public class userClass {
    private String name;
    private double accountBalance;
    private double monthlyBudget;
    private ArrayList<itemClass> individualItems;
    private ArrayList<sharedItemClass> sharedItems;
    private boolean hasConfirmed;

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
    
}
