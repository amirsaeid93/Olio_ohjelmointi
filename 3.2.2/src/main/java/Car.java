class Car extends AbstractVehicle {
    private int numberOfDoors;

    public Car(String fuelType, String color, int numberOfDoors) {
        super(fuelType, color, 4);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Car is starting... Vroom!");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping... Screech!");
    }

    @Override
    public String getInfo() {
        return "Car Information:\n" +
                "Type: Car\n" +
                super.getInfo() + "\n" +
                "Number of Doors: " + numberOfDoors;
    }

    @Override
    public void accelerate() {
        System.out.println("Car is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Car is braking...");
    }
}