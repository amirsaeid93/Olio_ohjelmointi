class Car implements Vehicle {
    private String fuelType;
    private String color;

    public Car(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Car Information:\n" +
                "Type: Car\n" +
                "Fuel: " + fuelType + "\n" +
                "Color: " + color;
    }
}