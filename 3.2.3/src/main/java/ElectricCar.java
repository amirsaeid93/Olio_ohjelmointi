class ElectricCar extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricCar(String color, int batteryCapacity) {
        super("Electric", color, 4); // Electric cars have 4 wheels
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void start() {
        System.out.println("Electric Car is starting... Whirr!");
    }

    @Override
    public void stop() {
        System.out.println("Electric Car is stopping... Shhh!");
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\n" +
                "Type: Electric Car\n" +
                super.getInfo() + "\n" +
                "Battery Capacity: " + batteryCapacity + " kWh";
    }

    @Override
    public void accelerate() {
        System.out.println("Electric Car is accelerating... Zoom!");
    }

    @Override
    public void brake() {
        System.out.println("Electric Car is braking... Squeak!");
    }

    @Override
    public void charge() {
        System.out.println("Electric Car is charging... Zzzzz...");
    }
}