class NumberPrinter {
    private int currentNumber;
    private final int maxNumber;

    public NumberPrinter(int start, int max) {
        this.currentNumber = start;
        this.maxNumber = max;
    }

    public synchronized void printOdd() {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Odd Thread: " + currentNumber);
                currentNumber++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Even Thread: " + currentNumber);
                currentNumber++;
                notify();
            }
        }
    }
}

public class MultiThreadedNumberPrinting {
    public static void main(String[] args) {
        int start = 1;
        int end = 20;

        NumberPrinter printer = new NumberPrinter(start, end);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Printing complete.");
    }
}