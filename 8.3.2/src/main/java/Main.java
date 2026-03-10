import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        // Creates a List of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));
        System.out.println("Original List: " + numbers);

        // Filters Even Numbers: Using lambda expressions to filter out the even numbers.
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After Filtering Even Numbers (only odds remain): " + numbers);

        // Doubles the Odd Numbers: Using lambda expressions to double the values of odd numbers.
        numbers.replaceAll(n -> n * 2);
        System.out.println("After Doubling the Odd Numbers: " + numbers);

        // Sums the Numbers: Using a lambda expression to calculate the sum.
        // And it uses AtomicInteger as a mutable wrapper to hold the sum,
        // as variables used in lambdas must be effectively final.
        AtomicInteger sum = new AtomicInteger(0);
        numbers.forEach(n -> sum.addAndGet(n));

        System.out.println("Sum of the final list: " + sum.get());
    }
}