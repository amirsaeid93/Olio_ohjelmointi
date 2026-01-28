public class Main {
    public static void main(String[] args) {
        Bus cityBus = new Bus("Mercedes-Benz", "Citaro", 2020, 200.0, 0.2, 50);

        System.out.println("Initial Bus State:");
        System.out.println(cityBus);

        cityBus.passengerEnter(20);
        System.out.println(cityBus);

        cityBus.passengerEnter(35);
        System.out.println(cityBus);

        cityBus.passengerExit(10);
        System.out.println(cityBus);

        cityBus.passengerExit(30);
        System.out.println(cityBus);

        cityBus.accelerate(10);
        System.out.println(cityBus);

        cityBus.decelerate(5);
        System.out.println(cityBus);

        cityBus.drive(50);
        System.out.println(cityBus);

        cityBus.refuel(50);
        System.out.println(cityBus);
    }
}