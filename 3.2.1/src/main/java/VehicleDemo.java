public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");


        Car myCar = new Car("Petrol", "Red");
        Motorcycle myMotorcycle = new Motorcycle("Gasoline", "Black");
        Bus myBus = new Bus("Diesel", 40);


        myCar.start();
        myCar.stop();
        System.out.println(myCar.getInfo() + "\n");

        myMotorcycle.start();
        myMotorcycle.stop();
        System.out.println(myMotorcycle.getInfo() + "\n");

        myBus.start();
        myBus.stop();
        System.out.println(myBus.getInfo() + "\n");
    }
}