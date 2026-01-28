abstract class AbstractVehicle implements Vehicle {
    protected String fuelType;
    protected String color;
    protected int numberOfWheels;

    public AbstractVehicle(String fuelType, String color, int numberOfWheels) {
        this.fuelType = fuelType;
        this.color = color;
        this.numberOfWheels = numberOfWheels;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void honk() {
        System.out.println("Honk! Honk!");
    }

    public abstract void accelerate();

    public abstract void brake();

    @Override
    public String getInfo() {
        return "Fuel Type: " + fuelType + "\n" +
                "Color: " + color + "\n" +
                "Number of Wheels: " + numberOfWheels;
    }
}