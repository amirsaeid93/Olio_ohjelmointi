public class ItemDetails {
    private double cost;
    private String category;
    private int quantity;

    public ItemDetails(double cost, String category, int quantity) {
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
