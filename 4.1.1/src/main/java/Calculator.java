public class Calculator {
    private int value;

    public Calculator() {
        this.value = 0;
    }


    public void reset() {
        this.value = 0;
    }


    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        this.value += number;
    }


    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.add(10);
            calculator.add(20);
            calculator.add(30);
            System.out.println("Current value: " + calculator.getValue());
            calculator.reset();
            System.out.println("Value after reset: " + calculator.getValue());
            calculator.add(15);
            System.out.println("Current value: " + calculator.getValue());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}