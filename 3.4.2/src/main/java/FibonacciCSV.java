import java.io.FileWriter;
import java.io.IOException;

public class FibonacciCSV {
    public static void main(String[] args) {
        long[] fibonacciSequence = generateFibonacciSequence(60);
        writeToCSV(fibonacciSequence, "fibonacci_sequence.csv");
    }

    private static long[] generateFibonacciSequence(int n) {
        long[] sequence = new long[n];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }

    private static void writeToCSV(long[] sequence, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Index,Value\n");
            for (int i = 0; i < sequence.length; i++) {
                writer.append(i + "," + sequence[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

