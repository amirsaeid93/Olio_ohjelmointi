class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String fuelType, String color, int capacity) {
        super(fuelType, color, 6);
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting... Chugga Chugga!");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping... Hiss!");
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Type: Bus\n" +
                super.getInfo() + "\n" +
                "Capacity: " + capacity + " passengers";
    }

    @Override
    public void accelerate() {
        System.out.println("Bus is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Bus is braking...");
    }
}