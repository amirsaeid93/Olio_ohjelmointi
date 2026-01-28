public class Main {
    public static void main(String[] args) {
        Car regularCar = new Car("Toyota", "Camry", 2022, 60.0, 0.08);
        SportsCar sportsCar = new SportsCar("Ferrari", "488 GTB", 2023, 80.0, 0.1, 1.5, 1.2);

        System.out.println("Regular Car:");
        System.out.println(regularCar);
        regularCar.accelerate(20);
        System.out.println(regularCar);
        regularCar.decelerate(10);
        System.out.println(regularCar);
        regularCar.drive(100);
        System.out.println(regularCar);
        regularCar.refuel(20);
        System.out.println(regularCar);

        System.out.println("\nSports Car:");
        System.out.println(sportsCar);
        sportsCar.accelerate(20);
        System.out.println(sportsCar);
        sportsCar.decelerate(10);
        System.out.println(sportsCar);
        sportsCar.drive(100);
        System.out.println(sportsCar);
        sportsCar.refuel(20);
        System.out.println(sportsCar);
    }
}
