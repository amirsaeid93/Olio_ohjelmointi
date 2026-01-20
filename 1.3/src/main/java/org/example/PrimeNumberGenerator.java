package org.example;

import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start value (positive integer): ");
        int start = scanner.nextInt();

        System.out.print("Enter the end value (positive integer, greater than start): ");
        int end = scanner.nextInt();

        scanner.close();


        if (start <= 0 || end <= 0 || start >= end) {
            System.out.println("Invalid input. Please ensure start and end are positive integers and start < end.");
            return;
        }


        System.out.println("Prime numbers between " + start + " and " + end + " are:");

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }


    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }


        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }


        return true;
    }
}
