class Car {
    private String make;
    private String model;
    private int year;
    private double speed;
    private double fuelLevel;
    private double fuelCapacity;
    private double fuelConsumptionRate;

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

    public void accelerate(double increment) {
        if (fuelLevel > 0) {
            speed += increment;
            if (speed > 200) {
                speed = 200;
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

class SportsCar extends Car {
    private double accelerationRate;
    private double decelerationRate;
    private double sportsFuelConsumptionRate;

    public SportsCar(String make, String model, int year, double fuelCapacity, double fuelConsumptionRate, double accelerationRate, double decelerationRate) {
        super(make, model, year, fuelCapacity, fuelConsumptionRate);
        this.accelerationRate = accelerationRate;
        this.decelerationRate = decelerationRate;
        this.sportsFuelConsumptionRate = fuelConsumptionRate * 1.5;
    }

    @Override
    public void accelerate(double increment) {
        if (getFuelLevel() > 0) {
            double actualIncrement = increment * accelerationRate;
            super.accelerate(actualIncrement);
            consumeFuelSports(actualIncrement * 0.01);
        } else {
            System.out.println("Out of fuel!");
        }
    }

    @Override
    public void decelerate(double decrement) {
        double actualDecrement = decrement * decelerationRate;
        super.decelerate(actualDecrement);
    }

    private void consumeFuelSports(double distance) {
        double fuelConsumed = distance * sportsFuelConsumptionRate;
        double newFuelLevel = getFuelLevel() - fuelConsumed;
        if (newFuelLevel < 0) {
            newFuelLevel = 0;
        }


        try {
            java.lang.reflect.Field fuelLevelField = Car.class.getDeclaredField("fuelLevel");
            fuelLevelField.setAccessible(true);
            fuelLevelField.set(this, newFuelLevel);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "SportsCar{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", speed=" + getSpeed() +
                ", fuelLevel=" + getFuelLevel() +
                '}';
    }
}

