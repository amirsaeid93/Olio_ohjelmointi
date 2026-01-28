class Motorcycle extends AbstractVehicle {
    private boolean hasSidecar;

    public Motorcycle(String fuelType, String color, boolean hasSidecar, double fuelEfficiency) {
        super(fuelType, color, 2, fuelEfficiency);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting... Brum!");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping... Skrr!");
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\n" +
                "Type: Motorcycle\n" +
                super.getInfo() + "\n" +
                "Has Sidecar: " + hasSidecar;
    }

    @Override
    public void accelerate() {
        System.out.println("Motorcycle is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Motorcycle is braking...");
    }
}
