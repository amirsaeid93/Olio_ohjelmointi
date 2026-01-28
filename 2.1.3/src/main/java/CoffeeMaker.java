public class CoffeeMaker {
    private boolean isOn;
    private String coffeeType;
    private int coffeeAmount;

    public CoffeeMaker() {
        this.isOn = false;
        this.coffeeType = "normal";
        this.coffeeAmount = 10;
    }

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setCoffeeType(String coffeeType) {
        if (isOn) {
            if (coffeeType.equals("normal") || coffeeType.equals("espresso")) {
                this.coffeeType = coffeeType;
            } else {
                throw new IllegalArgumentException("Invalid coffee type. Choose 'normal' or 'espresso'.");
            }
        }
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        if (isOn) {
            if (coffeeAmount >= 10 && coffeeAmount <= 80) {
                this.coffeeAmount = coffeeAmount;
            } else {
                throw new IllegalArgumentException("Invalid coffee amount. Choose between 10 and 80 ml.");
            }
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}