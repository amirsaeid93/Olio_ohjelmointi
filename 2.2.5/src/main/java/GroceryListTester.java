public class GroceryListTester {
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();


        manager.addItem("Apples", 1.50, "Fruits", 10);
        manager.addItem("Milk", 2.00, "Dairy", 5);
        manager.addItem("Bread", 1.75, "Bakery", 3);
        manager.addItem("Bananas", 1.20, "Fruits", 7);
        manager.addItem("Cheese", 3.50, "Dairy", 2);


        System.out.println("Initial Grocery List:");
        manager.displayList();


        System.out.println("\nTotal Cost: $" + manager.calculateTotalCost());


        System.out.println("\nDisplaying items in the 'Fruits' category:");
        manager.displayByCategory("Fruits");

        System.out.println("\nDisplaying items in the 'Dairy' category:");
        manager.displayByCategory("Dairy");


        System.out.println("\nUpdating quantity of 'Milk' to 8...");
        manager.updateQuantity("Milk", 8);


        System.out.println("\nAvailable Items:");
        manager.displayAvailableItems();


        System.out.println("\nUpdated Grocery List:");
        manager.displayList();


        System.out.println("\nTotal Cost after updating quantities: $" + manager.calculateTotalCost());
    }
}