public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");


        Car myCar = new Car("Petrol", "Red", 4);
        Motorcycle myMotorcycle = new Motorcycle("Gasoline", "Black", false);
        Bus myBus = new Bus("Diesel", "Yellow", 40);


        System.out.println("--- Car ---");
        myCar.start();
        myCar.accelerate();
        myCar.honk();
        myCar.brake();
        myCar.stop();
        System.out.println(myCar.getInfo() + "\n");


        System.out.println("--- Motorcycle ---");
        myMotorcycle.start();
        myMotorcycle.accelerate();
        myMotorcycle.honk();
        myMotorcycle.brake();
        myMotorcycle.stop();
        System.out.println(myMotorcycle.getInfo() + "\n");


        System.out.println("--- Bus ---");
        myBus.start();
        myBus.accelerate();
        myBus.honk();
        myBus.brake();
        myBus.stop();
        System.out.println(myBus.getInfo() + "\n");
    }
}