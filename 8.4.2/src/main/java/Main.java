import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Given a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original List: " + numbers);

        // 1. Filter out all the even numbers from the list.
        List<Integer> oddNumbers = numbers.stream()
                                          .filter(n -> n % 2 != 0) // Lambda expression for filtering
                                          .collect(Collectors.toList());
        System.out.println("After Filtering (Odd Numbers): " + oddNumbers);

        // 2. Double each remaining number.
        List<Integer> doubledOddNumbers = oddNumbers.stream()
                                                    .map(n -> n * 2) // Lambda expression for transforming
                                                    .collect(Collectors.toList());
        System.out.println("After Doubling Odd Numbers: " + doubledOddNumbers);

        // 3. Find the sum of the resulting numbers.
        int sum = doubledOddNumbers.stream()
                                   .mapToInt(Integer::intValue) // Convert to IntStream for sum() method
                                   .sum(); // Functional operation to sum

        // Alternative sum using reduce:
        // int sum = doubledOddNumbers.stream()
        //                            .reduce(0, (a, b) -> a + b); // Lambda expression for reducing/summing

        System.out.println("Sum of the resulting numbers: " + sum);
    }
}