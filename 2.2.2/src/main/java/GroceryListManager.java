import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, cost);
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
        } else {
            System.out.println(item + " is not in the list.");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        int index = 1;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " - $" + entry.getValue());
            index++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();


        manager.addItem("Apples", 1.50);
        manager.addItem("Milk", 2.00);
        manager.addItem("Bread", 1.75);


        manager.displayList();


        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));


        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");


        System.out.println("\nUpdated Grocery List:");
        manager.displayList();


        System.out.println("\nTotal Cost: $" + manager.calculateTotalCost());
    }
}
