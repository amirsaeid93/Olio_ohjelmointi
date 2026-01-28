public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 50, 180);
        myCar.fillTank();


        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }


        myCar.fillTank();
        boolean cruiseControlOn = myCar.turnOnCruiseControl(100);
        if (cruiseControlOn) {
            System.out.println("Cruise control is on. Target speed is " + myCar.getTargetSpeed() + " km/h");
        } else {
            System.out.println("Cruise control could not be turned on.");
        }


        for (int i = 0; i < 10; i++) {
            myCar.updateCruiseControl();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.turnOffCruiseControl();
        System.out.println("Cruise control is off.");
    }
}