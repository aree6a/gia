
import java.util.ArrayList;
import java.util.List;


public class main {

    // Lists of items for 2 different supermarkets
    public List<itemClass> superMarket1 = new ArrayList<>();
    public List<itemClass> superMarket2 = new ArrayList<>();

    // Initialize supermarket items
    public void initializeSuperMarkets() {
        superMarket1.add(new itemClass("Eggs", 2, true));
        superMarket1.add(new itemClass("Milk", 1.2, true));
        superMarket1.add(new itemClass("Bread", 1, true));
        superMarket1.add(new itemClass("Butter", 1, true));
        superMarket1.add(new itemClass("Chicken", 5.4, true));
        superMarket1.add(new itemClass("Dish soap", 3, false));
        superMarket1.add(new itemClass("Shampoo", 4.5, true));
        superMarket1.add(new itemClass("Toilet Paper", 2.8, true));
        superMarket1.add(new itemClass("Notebook and pen combo", 2.5, true));
        superMarket1.add(new itemClass("Batteries", 6.0, true));
        superMarket1.add(new itemClass("Dog Food", 8.5, false));

        superMarket2.add(new itemClass("Eggs", 1.6, true));
        superMarket2.add(new itemClass("Milk", 1.4, true));
        superMarket2.add(new itemClass("Bread", 0.7, true));
        superMarket2.add(new itemClass("Butter", 1.8, true));
        superMarket2.add(new itemClass("Chicken", 4.9, true));
        superMarket2.add(new itemClass("Dish soap", 4, true));
        superMarket2.add(new itemClass("Shampoo", 3, false));
        superMarket2.add(new itemClass("Toilet Paper", 2.4, true));
        superMarket2.add(new itemClass("Notebook and pen combo", 3.0, false));
        superMarket2.add(new itemClass("Batteries", 5.5, false));
        superMarket2.add(new itemClass("Dog Food", 10.0, true));
    }
    //cooking

    public List<userClass> users = new ArrayList<>();

    //we will initialise users 
    public void intializeusers() {
        users.add(new userClass("Ismaiel", 2000.0, 250));
        users.add(new userClass("Ghuas", 1252.0, 440));
        users.add(new userClass("Hassan", 1701.0, 600));
        users.add(new userClass("Ziad", 1926.0, 200));
        users.add(new userClass("Areeba", 10000.0, 300));

    }


    
        
    public static void main(String[] args) {
        System.out.println("test");
        // prompt for username, chosen supermarket

        // initiate order object with username and supermarket

        // display items from the chosen supermarket to the user

        // loop for user to keep adding items, warning when exceeding budget and when exceeding balance. add the item to the users item list.
        // also prompt user to add shared items (potentially after adding their normal items). add the item to the users shared items.
        // we would also need to keep track of who they want to share it with so we can add it to their items too.

        // exit loop once user finishes adding items and then either start a new loop for next user or allow finalisation.
        // we repeat this until max number of users have done it which we will just hardcode to number of users we initialise.
        // we need to make sure we track every user who has participated to the order, we do this by adding them to the list of participants in Order class.

        // after they press finalisation, we need confirmation from each user that was a part of the order. to simulate this we will simply display their order, associated costs,
        // balance before and after, and say "username do you accept"
        
        // we do this for each user and then once all have confirmed we will "submit" the order
    }
}
