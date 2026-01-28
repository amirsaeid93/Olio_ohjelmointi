class Car {
    private String make;
    private String model;
    private int year;
    private double speed;
    private double fuelLevel;
    private double fuelCapacity;
    protected double fuelConsumptionRate;

    public Car(String make, String model, int year, double fuelCapacity, double fuelConsumptionRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
        this.fuelLevel = fuelCapacity;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void accelerate(double increment) {
        if (fuelLevel > 0) {
            speed += increment;
            if (speed > 150) {
                speed = 150;
            }
            consumeFuel(increment * 0.01);
        } else {
            System.out.println("Out of fuel!");
        }
    }

    public void decelerate(double decrement) {
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
    }

    public void refuel(double amount) {
        if (fuelLevel + amount <= fuelCapacity) {
            fuelLevel += amount;
        } else {
            fuelLevel = fuelCapacity;
            System.out.println("Fuel tank is full!");
        }
    }

    private void consumeFuel(double distance) {
        double fuelConsumed = distance * fuelConsumptionRate;
        fuelLevel -= fuelConsumed;
        if (fuelLevel < 0) {
            fuelLevel = 0;
        }
    }

    public void drive(double distance) {
        if (fuelLevel > 0) {
            consumeFuel(distance);
            System.out.println("Driving " + distance + " km. Remaining fuel: " + fuelLevel + " liters.");
        } else {
            System.out.println("Out of fuel!");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", speed=" + speed +
                ", fuelLevel=" + fuelLevel +
                '}';
    }
}