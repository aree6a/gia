
import java.util.List;

public class userClass {
    private String name;
    private double accountBalance;
    private double monthlyBudget;
    private List<itemClass> individualItems;
    private List<sharedItemClass> sharedItems;
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

    public List<itemClass> getIndividualItems() {
        return individualItems;
    }
    
    public void setIndividualItems(List<itemClass> individualItems) {
        this.individualItems = individualItems;
    }
    
    public List<sharedItemClass> getSharedItems() {
        return sharedItems;
    }
    
    public void setSharedItems(List<sharedItemClass> sharedItems) {
        this.sharedItems = sharedItems;
    }
    
    public boolean isHasConfirmed() {
        return hasConfirmed;
    }
    
    public void setHasConfirmed(boolean hasConfirmed) {
        this.hasConfirmed = hasConfirmed;
    }
    
}
