abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String fuelType;
    protected String color;
    protected int numberOfWheels;
    protected double fuelEfficiency;

    public AbstractVehicle(String fuelType, String color, int numberOfWheels, double fuelEfficiency) {
        this.fuelType = fuelType;
        this.color = color;
        this.numberOfWheels = numberOfWheels;
        this.fuelEfficiency = fuelEfficiency;
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

    @Override
    public void charge() {
        System.out.println("Not possible to charge.");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}