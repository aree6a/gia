import java.util.ArrayList;

public class sharedItemClass extends itemClass {
    private ArrayList<userClass> sharedBy;

    public sharedItemClass(String name, double price, boolean availability) {
        super(name, price, availability);
        this.sharedBy = new ArrayList<>();
    }

    public ArrayList<userClass> getSharedBy() {
        return sharedBy;
    }

    public void addSharedBy(userClass user) {
        if (!sharedBy.contains(user)) {
            sharedBy.add(user);
        }
    }

    public int lengthSharedBy() {
        return sharedBy.size();
    }


    public double getCostPerUser() {
        if (sharedBy.isEmpty()) return 0.0;
        return getPrice() / sharedBy.size();
    }
}