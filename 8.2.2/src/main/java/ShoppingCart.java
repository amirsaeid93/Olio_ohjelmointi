import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {

    private static class Item {
        String name;
        double price;

        Item(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private final List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the shopping cart.
     * @param name The name of the item.
     * @param price The price of the item.
     */
    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    /**
     * Removes the first occurrence of an item with the specified name.
     * @param name The name of the item to remove.
     * @return true if an item was removed, false otherwise.
     */
    public boolean removeItem(String name) {
        Optional<Item> itemToRemove = items.stream()
                .filter(item -> item.name.equals(name))
                .findFirst();

        if (itemToRemove.isPresent()) {
            return items.remove(itemToRemove.get());
        }
        return false;
    }

    /**
     * Gets the total number of items in the cart.
     * @return The number of items.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Calculates the total cost of all items in the cart.
     * @return The total cost.
     */
    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.price;
        }
        return total;
    }
}