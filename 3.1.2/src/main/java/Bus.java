class Bus extends Car {
    private int passengerCapacity;
    private int currentPassengers;

    public Bus(String make, String model, int year, double fuelCapacity, double fuelConsumptionRate, int passengerCapacity) {
        super(make, model, year, fuelCapacity, fuelConsumptionRate);
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = 0;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public void passengerEnter(int numPassengers) {
        if (currentPassengers + numPassengers <= passengerCapacity) {
            currentPassengers += numPassengers;
            System.out.println(numPassengers + " passengers entered. Current passengers: " + currentPassengers);
        } else {
            System.out.println("Cannot take " + numPassengers + " passengers. Bus is full. Current passengers: " + currentPassengers);
        }
    }

    public void passengerExit(int numPassengers) {
        if (currentPassengers - numPassengers >= 0) {
            currentPassengers -= numPassengers;
            System.out.println(numPassengers + " passengers exited. Current passengers: " + currentPassengers);
        } else {
            System.out.println("Cannot remove " + numPassengers + " passengers. Not enough passengers on board. Current passengers: " + currentPassengers);
        }
    }

    @Override
    public void accelerate(double increment) {
        if (getFuelLevel() > 0) {
            double actualIncrement = increment * 0.8; // Buses accelerate slower
            super.accelerate(actualIncrement);
            consumeFuelBus(actualIncrement * 0.01); // Consume fuel based on acceleration
        } else {
            System.out.println("Out of fuel!");
        }
    }

    @Override
    public void decelerate(double decrement) {
        double actualDecrement = decrement * 0.9; // Buses decelerate slower
        super.decelerate(actualDecrement);
    }

    private void consumeFuelBus(double distance) {
        double fuelConsumed = distance * (getFuelConsumptionRate() * 1.2); // Buses consume more fuel
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
        return "Bus{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", speed=" + getSpeed() +
                ", fuelLevel=" + getFuelLevel() +
                ", passengerCapacity=" + passengerCapacity +
                ", currentPassengers=" + currentPassengers +
                '}';
    }
}
