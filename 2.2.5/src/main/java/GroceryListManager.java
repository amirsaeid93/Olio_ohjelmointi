import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, ItemDetails> groceryList = new HashMap<>();

    public void addItem(String item, double cost, String category, int quantity) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new ItemDetails(cost, category, quantity));
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).setQuantity(newQuantity);
        } else {
            System.out.println(item + " is not in the list.");
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (Map.Entry<String, ItemDetails> entry : groceryList.entrySet()) {
            if (entry.getValue().getQuantity() > 0) {
                System.out.println(entry.getKey() + " - $" + entry.getValue().getCost() + " - Quantity: " + entry.getValue().getQuantity());
            }
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (Map.Entry<String, ItemDetails> entry : groceryList.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue().getCost() + " - Category: " + entry.getValue().getCategory() + " - Quantity: " + entry.getValue().getQuantity());
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Category: " + category);
        int index = 1;
        for (Map.Entry<String, ItemDetails> entry : groceryList.entrySet()) {
            if (entry.getValue().getCategory().equals(category)) {
                System.out.println(index + ". " + entry.getKey() + " - $" + entry.getValue().getCost() + " - Quantity: " + entry.getValue().getQuantity());
                index++;
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (ItemDetails details : groceryList.values()) {
            totalCost += details.getCost() * details.getQuantity();
        }
        return totalCost;
    }
}