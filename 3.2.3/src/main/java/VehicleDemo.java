public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");


        Car myCar = new Car("Petrol", "Red", 4);
        Motorcycle myMotorcycle = new Motorcycle("Gasoline", "Black", false);
        Bus myBus = new Bus("Diesel", "Yellow", 40);
        ElectricCar myElectricCar = new ElectricCar("Blue", 75);
        ElectricMotorcycle myElectricMotorcycle = new ElectricMotorcycle("Silver", 20);


        System.out.println("--- Car ---");
        myCar.start();
        myCar.accelerate();
        myCar.honk();
        myCar.brake();
        myCar.stop();
        myCar.charge();
        System.out.println(myCar.getInfo() + "\n");


        System.out.println("--- Motorcycle ---");
        myMotorcycle.start();
        myMotorcycle.accelerate();
        myMotorcycle.honk();
        myMotorcycle.brake();
        myMotorcycle.stop();
        myMotorcycle.charge();
        System.out.println(myMotorcycle.getInfo() + "\n");


        System.out.println("--- Bus ---");
        myBus.start();
        myBus.accelerate();
        myBus.honk();
        myBus.brake();
        myBus.stop();
        myBus.charge();
        System.out.println(myBus.getInfo() + "\n");


        System.out.println("--- Electric Car ---");
        myElectricCar.start();
        myElectricCar.accelerate();
        myElectricCar.honk();
        myElectricCar.brake();
        myElectricCar.stop();
        myElectricCar.charge();
        System.out.println(myElectricCar.getInfo() + "\n");


        System.out.println("--- Electric Motorcycle ---");
        myElectricMotorcycle.start();
        myElectricMotorcycle.accelerate();
        myElectricMotorcycle.honk();
        myElectricMotorcycle.brake();
        myElectricMotorcycle.stop();
        myElectricMotorcycle.charge();
        System.out.println(myElectricMotorcycle.getInfo() + "\n");
    }
}