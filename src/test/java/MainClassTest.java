import static org.junit.jupiter.api.Assertions.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MainClassTest {

    @BeforeEach
    public void setup() {
        Main.initializeSuperMarkets();
        Main.initializeUsers();
    }

    @Test
    public void testGetItemByName() {
        itemClass item = Main.getItemByName(Main.superMarket1, "Eggs");
        assertNotNull(item);
        assertEquals("Eggs", item.getName());
        assertEquals(2, item.getPrice());

        item = Main.getItemByName(Main.superMarket1, "Non-existent Item");
        assertNull(item);
    }

    @Test
    public void testAddIndividualItems() {
        userClass user = Main.users.get(0); // Select the first user
        itemClass eggs = Main.getItemByName(Main.superMarket1, "Eggs");
        itemClass milk = Main.getItemByName(Main.superMarket1, "Milk");


        user.addIndividualItems(eggs);
        user.addIndividualItems(milk);

        List<itemClass> userItems = user.getIndividualItems();
        assertEquals(2, userItems.size()); // Should have 2 items
        assertTrue(userItems.contains(eggs));
        assertTrue(userItems.contains(milk));
    }


    @Test
    public void testFinalizeOrder() {
//        userClass user1 = Main.users.get(0);
//        itemClass eggs = Main.getItemByName(Main.superMarket1, "Eggs");
//        itemClass milk = Main.getItemByName(Main.superMarket1, "Milk");
//
//
//        user1.addIndividualItems(eggs);
//        user1.addIndividualItems(milk);
//
//        double initialBalance = user1.getAccountBalance();
//        double totalCost = eggs.getPrice() + milk.getPrice();

        //not sure how to implement
    }

    @Test
    public void testAddItemLogic() {

    }

    // Test whether shared item logic works
    @Test
    public void testSharedItemLogic() {

    }
}


