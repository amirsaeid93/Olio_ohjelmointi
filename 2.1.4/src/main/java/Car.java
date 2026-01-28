public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double gasolineTankCapacity;
    private double topSpeed;
    private boolean cruiseControlOn;
    private double targetSpeed;
    private static final double MIN_CRUISE_SPEED = 30;
    private static final double MAX_CRUISE_SPEED = 150;

    public Car(String typeName) {
        this(typeName, 100, 200);
    }

    public Car(String typeName, double gasolineTankCapacity, double topSpeed) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
        this.gasolineTankCapacity = gasolineTankCapacity;
        this.topSpeed = topSpeed;
        this.cruiseControlOn = false;
        this.targetSpeed = 0;
    }

    public void accelerate() {
        if (gasolineLevel > 0 && speed < topSpeed) {
            speed = Math.min(speed + 10, topSpeed);
        } else {
            speed = 0;
        }
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        } else {
            speed = 0;
        }
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = gasolineTankCapacity;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    public boolean turnOnCruiseControl(double targetSpeed) {
        if (targetSpeed >= MIN_CRUISE_SPEED && targetSpeed <= MAX_CRUISE_SPEED && targetSpeed <= topSpeed) {
            this.targetSpeed = targetSpeed;
            this.cruiseControlOn = true;
            return true;
        } else {
            this.cruiseControlOn = false;
            return false;
        }
    }

    public void turnOffCruiseControl() {
        this.cruiseControlOn = false;
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public void updateCruiseControl() {
        if (cruiseControlOn) {
            if (speed < targetSpeed) {
                accelerate();
            } else if (speed > targetSpeed) {
                decelerate(10);
            }
            if (speed == targetSpeed) {
                cruiseControlOn = false;
            }
        }
    }
}
