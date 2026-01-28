public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double gasolineTankCapacity;
    private double topSpeed;

    public Car(String typeName) {
        this(typeName, 100, 200);
    }

    public Car(String typeName, double gasolineTankCapacity, double topSpeed) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
        this.gasolineTankCapacity = gasolineTankCapacity;
        this.topSpeed = topSpeed;
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
}

