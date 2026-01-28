public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");


        Car myCar = new Car("Petrol", "Red", 4, 30.0);
        Motorcycle myMotorcycle = new Motorcycle("Gasoline", "Black", false, 60.0);
        Bus myBus = new Bus("Diesel", "Yellow", 40, 6.0);
        ElectricCar myElectricCar = new ElectricCar("Blue", 75, 0.2);
        ElectricMotorcycle myElectricMotorcycle = new ElectricMotorcycle("Silver", 20, 0.1);


        System.out.println("--- Car ---");
        myCar.start();
        myCar.accelerate();
        myCar.honk();
        myCar.brake();
        myCar.stop();
        myCar.charge();
        System.out.println(myCar.getInfo());
        System.out.println("Fuel Efficiency: " + myCar.calculateFuelEfficiency() + " miles per gallon\n");


        System.out.println("--- Motorcycle ---");
        myMotorcycle.start();
        myMotorcycle.accelerate();
        myMotorcycle.honk();
        myMotorcycle.brake();
        myMotorcycle.stop();
        myMotorcycle.charge();
        System.out.println(myMotorcycle.getInfo());
        System.out.println("Fuel Efficiency: " + myMotorcycle.calculateFuelEfficiency() + " miles per gallon\n");


        System.out.println("--- Bus ---");
        myBus.start();
        myBus.accelerate();
        myBus.honk();
        myBus.brake();
        myBus.stop();
        myBus.charge();
        System.out.println(myBus.getInfo());
        System.out.println("Fuel Efficiency: " + myBus.calculateFuelEfficiency() + " miles per gallon\n");


        System.out.println("--- Electric Car ---");
        myElectricCar.start();
        myElectricCar.accelerate();
        myElectricCar.honk();
        myElectricCar.brake();
        myElectricCar.stop();
        myElectricCar.charge();
        System.out.println(myElectricCar.getInfo());
        System.out.println("Fuel Efficiency: " + myElectricCar.calculateFuelEfficiency() + " kWh per kilometer\n");


        System.out.println("--- Electric Motorcycle ---");
        myElectricMotorcycle.start();
        myElectricMotorcycle.accelerate();
        myElectricMotorcycle.honk();
        myElectricMotorcycle.brake();
        myElectricMotorcycle.stop();
        myElectricMotorcycle.charge();
        System.out.println(myElectricMotorcycle.getInfo());
        System.out.println("Fuel Efficiency: " + myElectricMotorcycle.calculateFuelEfficiency() + " kWh per kilometer\n");
    }
}