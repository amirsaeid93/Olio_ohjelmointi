package org.example;

import java.util.Scanner;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();


        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }


        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < size; i++) {
            int currentSum = 0;
            for (int j = i; j < size; j++) {
                currentSum += array[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i;
                    end = j;
                }
            }
        }


        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + (start + 1) + "-" + (end + 1));

        scanner.close();
    }
}
