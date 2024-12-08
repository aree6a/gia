import java.util.ArrayList;

public class sharedItemClass {
    private ArrayList<userClass> sharedBy;

    public ArrayList<userClass> getSharedBy() {
        return sharedBy;
    }

    public void addSharedBy(userClass user) {
        sharedBy.add(user);
    }

    public int lengthSharedBy() {
        return sharedBy.size();
    }
}
