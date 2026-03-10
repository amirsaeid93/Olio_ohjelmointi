import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        // Defines an array of numbers
        double[] numbers = {10.5, 20.0, 30.5, 40.0, 50.5};
        System.out.println("Original array: " + Arrays.toString(numbers));

        // Calculates the mean using Java functional programming techniques
        // 1. Arrays.stream(numbers) creates a DoubleStream from the array.
        // 2. .average() is a terminal operation that calculates the average of the stream elements.
        //    It returns an OptionalDouble to handle the case of an empty array.
        OptionalDouble optionalMean = Arrays.stream(numbers).average();

        // Checks if a value is present in the OptionalDouble and prints the result
        if (optionalMean.isPresent()) {
            double mean = optionalMean.getAsDouble();
            System.out.println("The mean of the array is: " + mean);
        } else {
            System.out.println("The array is empty, so no mean can be calculated.");
        }

        // Also an Example with an empty array
        double[] emptyArray = {};
        System.out.println("\nOriginal array: " + Arrays.toString(emptyArray));
        OptionalDouble emptyOptionalMean = Arrays.stream(emptyArray).average();
        if (emptyOptionalMean.isPresent()) {
            System.out.println("The mean of the array is: " + emptyOptionalMean.getAsDouble());
        } else {
            System.out.println("The array is empty, so no mean can be calculated.");
        }
    }
}