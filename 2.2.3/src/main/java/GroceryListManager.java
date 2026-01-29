import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, HashMap<String, Double>> groceryList = new HashMap<>();

    public void addItem(String item, double cost, String category) {
        groceryList.putIfAbsent(category, new HashMap<>());
        HashMap<String, Double> categoryItems = groceryList.get(category);
        if (!categoryItems.containsKey(item)) {
            categoryItems.put(item, cost);
        } else {
            System.out.println(item + " is already in the " + category + " category.");
        }
    }

    public void removeItem(String item, String category) {
        if (groceryList.containsKey(category) && groceryList.get(category).containsKey(item)) {
            groceryList.get(category).remove(item);
        } else {
            System.out.println(item + " is not in the " + category + " category.");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (Map.Entry<String, HashMap<String, Double>> categoryEntry : groceryList.entrySet()) {
            String category = categoryEntry.getKey();
            System.out.println("Category: " + category);
            int index = 1;
            for (Map.Entry<String, Double> itemEntry : categoryEntry.getValue().entrySet()) {
                System.out.println(index + ". " + itemEntry.getKey() + " - $" + itemEntry.getValue());
                index++;
            }
        }
    }

    public void displayByCategory(String category) {
        if (groceryList.containsKey(category)) {
            System.out.println("Category: " + category);
            int index = 1;
            for (Map.Entry<String, Double> itemEntry : groceryList.get(category).entrySet()) {
                System.out.println(index + ". " + itemEntry.getKey() + " - $" + itemEntry.getValue());
                index++;
            }
        } else {
            System.out.println("No items found in the " + category + " category.");
        }
    }

    public boolean checkItem(String item, String category) {
        return groceryList.containsKey(category) && groceryList.get(category).containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (HashMap<String, Double> categoryItems : groceryList.values()) {
            for (double cost : categoryItems.values()) {
                totalCost += cost;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();


        manager.addItem("Apples", 1.50, "Fruits");
        manager.addItem("Milk", 2.00, "Dairy");
        manager.addItem("Bread", 1.75, "Bakery");


        manager.displayList();


        System.out.println("\nDisplaying items in the 'Dairy' category:");
        manager.displayByCategory("Dairy");


        System.out.println("\nIs \"Milk\" in the \"Dairy\" category? " + manager.checkItem("Milk", "Dairy"));


        System.out.println("\nRemoving \"Milk\" from the \"Dairy\" category...");
        manager.removeItem("Milk", "Dairy");


        System.out.println("\nUpdated Grocery List:");
        manager.displayList();


        System.out.println("\nTotal Cost: $" + manager.calculateTotalCost());
    }
}
