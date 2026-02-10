import java.util.Random;
import java.util.concurrent.*;

public class ParallelNumberSummation {
    public static void main(String[] args) {
        int arraySize = 100000;
        int[] numbers = new Random().ints(arraySize, 1, 100).toArray();


        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processor cores: " + numCores);


        int chunkSize = (int) Math.ceil((double) arraySize / numCores);


        ExecutorService executor = Executors.newFixedThreadPool(numCores);


        Future<Integer>[] futures = new Future[numCores];
        for (int i = 0; i < numCores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, arraySize);
            futures[i] = executor.submit(new PartialSumCalculator(numbers, start, end));
        }


        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        executor.shutdown();


        System.out.println("Total Sum: " + totalSum);
    }
}


class PartialSumCalculator implements Callable<Integer> {
    private final int[] numbers;
    private final int start;
    private final int end;

    public PartialSumCalculator(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}