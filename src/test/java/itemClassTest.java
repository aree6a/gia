import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class itemClassTest {

    @Test
    public void testItemInitialization() {
        itemClass item = new itemClass("Milk", 1.2, true);
        assertEquals("Milk", item.getName(), "Item name should be 'Milk'.");
        assertEquals(1.2, item.getPrice(), 0.0001, "Item price should be 1.2.");
        assertTrue(item.getAvailability(), "Item should be available.");
    }

    @Test
    public void testAvailability() {
        itemClass item = new itemClass("Eggs", 2.0, false);
        assertFalse(item.getAvailability(), "Item availability should be false.");
    }

    @Test
    public void testSetPrice() {
        itemClass item = new itemClass("Bread", 1.0, true);
        item.setPrice(1.5);
        assertEquals(1.5, item.getPrice(), 0.0001, "Item price should be updated to 1.5.");
    }

}