import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItem() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);

        assertEquals(2, cart.getItemCount(), "Should have 2 items after adding two different items.");
        assertEquals(1.5, cart.calculateTotal(), 0.01, "Total should be 1.5 after adding two items.");

        // Test adding the same item multiple times
        cart.addItem("Apple", 1.0);
        assertEquals(3, cart.getItemCount(), "Should have 3 items after adding an existing item again.");
        assertEquals(2.5, cart.calculateTotal(), 0.01, "Total should be 2.5 after adding Apple again.");
    }

    @Test
    void testRemoveItem() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);

        // Remove an existing item
        assertTrue(cart.removeItem("Apple"), "Should successfully remove Apple.");
        assertEquals(2, cart.getItemCount(), "Should have 2 items after removing Apple.");
        assertEquals(1.25, cart.calculateTotal(), 0.01, "Total should be 1.25 after removing Apple.");

        // Try to remove a non-existent item
        assertFalse(cart.removeItem("Grape"), "Should not remove a non-existent item.");
        assertEquals(2, cart.getItemCount(), "Item count should remain 2.");

        // Remove the last item
        assertTrue(cart.removeItem("Banana"), "Should successfully remove Banana.");
        assertTrue(cart.removeItem("Orange"), "Should successfully remove Orange.");
        assertEquals(0, cart.getItemCount(), "Should have 0 items after removing all.");
        assertEquals(0.0, cart.calculateTotal(), 0.01, "Total should be 0.0 after removing all.");

        // Test removing from an empty cart
        assertFalse(cart.removeItem("NonExistent"), "Should not remove from an empty cart.");
    }

    @Test
    void testCalculateTotal() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);

        assertEquals(2.25, cart.calculateTotal(), 0.01, "Total should be 2.25 for the given items.");

        // Test with empty cart
        ShoppingCart emptyCart = new ShoppingCart();
        assertEquals(0.0, emptyCart.calculateTotal(), 0.01, "Total should be 0.0 for an empty cart.");
    }

    @Test
    void testGetItemCount() {
        assertEquals(0, cart.getItemCount(), "Initial cart should have 0 items.");
        cart.addItem("Item1", 1.0);
        assertEquals(1, cart.getItemCount(), "Should have 1 item after adding one.");
        cart.addItem("Item2", 2.0);
        assertEquals(2, cart.getItemCount(), "Should have 2 items after adding two.");
        cart.removeItem("Item1");
        assertEquals(1, cart.getItemCount(), "Should have 1 item after removing one.");
    }

    @Test
    void testAddItemWithNegativePrice() {
        // Depending on requirements, negative prices might be disallowed.
        // For this test, we assume addItem should handle it gracefully or throw an exception.
        // For now, let's assume it adds it, but a real-world scenario might validate.
        cart.addItem("Discounted Item", -1.0);
        assertEquals(1, cart.getItemCount());
        assertEquals(-1.0, cart.calculateTotal(), 0.01);
    }
}