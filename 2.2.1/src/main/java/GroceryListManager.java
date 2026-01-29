import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
        } else {
            System.out.println(item + " is not in the list.");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();


        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");


        manager.displayList();


        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));


        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");


        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
    }
}
