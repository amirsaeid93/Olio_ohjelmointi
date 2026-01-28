class Motorcycle implements Vehicle {
    private String fuelType;
    private String color;

    public Motorcycle(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\n" +
                "Type: Motorcycle\n" +
                "Fuel: " + fuelType + "\n" +
                "Color: " + color;
    }
}