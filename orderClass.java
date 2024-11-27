import java.util.List;

public class orderClass {
    private String supermarket;
    private List<userClass> participants;
    private List<itemClass> allItems;
    private userClass initiator;
    private boolean isFinalized;

    public String getSupermarket() {
        return supermarket;
    }
    
    public void setSupermarket(String supermarket) {
        this.supermarket = supermarket;
    }

    public List<userClass> getParticipants() {
        return participants;
    }

    public void setParticipants(List<userClass> participants) {
        this.participants = participants;
    }

    public List<itemClass> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<itemClass> allItems) {
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
