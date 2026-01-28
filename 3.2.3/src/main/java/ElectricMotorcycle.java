class ElectricMotorcycle extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricMotorcycle(String color, int batteryCapacity) {
        super("Electric", color, 2); // Electric motorcycles have 2 wheels
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void start() {
        System.out.println("Electric Motorcycle is starting... Whirr!");
    }

    @Override
    public void stop() {
        System.out.println("Electric Motorcycle is stopping... Shhh!");
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle Information:\n" +
                "Type: Electric Motorcycle\n" +
                super.getInfo() + "\n" +
                "Battery Capacity: " + batteryCapacity + " kWh";
    }

    @Override
    public void accelerate() {
        System.out.println("Electric Motorcycle is accelerating... Zoom!");
    }

    @Override
    public void brake() {
        System.out.println("Electric Motorcycle is braking... Squeak!");
    }

    @Override
    public void charge() {
        System.out.println("Electric Motorcycle is charging... Zzzzz...");
    }
}
