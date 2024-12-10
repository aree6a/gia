
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class userClassTest {

    private userClass testUser;

    @BeforeEach
    public void setUp() {
        testUser = new userClass("TestUser", 100.0, 300, "testpass"); //test user object for entire test class
    }

    @Test
    public void testAddIndividualItems() {
        itemClass item = new itemClass("TestItem", 10.0, true); //test item object for this individual test
        testUser.addIndividualItems(item);

        assertEquals(1, testUser.getIndividualItems().size(), "User should have 1 item after adding one.");
        assertEquals("TestItem", testUser.getIndividualItems().get(0).getName(), "Item name should match the one added.");
        assertEquals(10.0, testUser.getIndividualItems().get(0).getPrice(), "Item price should match the one added.");
        assertTrue(testUser.getIndividualItems().get(0).getAvailability(), "Item availability should match the one added.");
        //bear in mind that this also tests the individual items get availability and constructor
    }

    @Test
    public void testUserPassword() {
        assertEquals("testpass", testUser.getPassword(), "Password should match the one set during initialization.");
    }


    @Test
    public void testSetAndGetAccountBalance() {
        testUser.setAccountBalance(50.0);
        assertEquals(50.0, testUser.getAccountBalance(), "User balance should reflect updated value.");
    }

}