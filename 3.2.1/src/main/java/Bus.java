class Bus implements Vehicle {
    private String fuelType;
    private int capacity;

    public Bus(String fuelType, int capacity) {
        this.fuelType = fuelType;
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Type: Bus\n" +
                "Fuel: " + fuelType + "\n" +
                "Capacity: " + capacity + " passengers";
    }
}
