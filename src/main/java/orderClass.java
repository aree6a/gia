import java.util.ArrayList;

public class orderClass {
    private String supermarket;
    private ArrayList<userClass> participants;
    private ArrayList<itemClass> allItems;
    private userClass initiator;
    private boolean isFinalized;

    public String getSupermarket() {
        return supermarket;
    }
    
    public void setSupermarket(String supermarket) {
        this.supermarket = supermarket;
    }

    public ArrayList<userClass> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<userClass> participants) {
        this.participants = participants;
    }

    public ArrayList<itemClass> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<itemClass> allItems) {
        this.allItems = allItems;
    }

    public userClass getInitiator() {
        return initiator;
    }
    
    public void setInitiator(userClass initiator) {
        this.initiator = initiator;
    }

    public boolean isFinalized(){
        return isFinalized;
    }

    public void setFinalized(boolean isFinalized) {
        this.isFinalized = isFinalized;
    }
}
