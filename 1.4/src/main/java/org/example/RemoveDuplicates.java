package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();


        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }


        int[] result = new int[size];
        HashSet<Integer> seen = new HashSet<>();
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (!seen.contains(array[i])) {
                seen.add(array[i]);
                result[index++] = array[i];
            }
        }


        System.out.println("The array without duplicates:");
        for (int i = 0; i < index; i++) {
            System.out.print(result[i] + " ");
        }

        scanner.close();
    }
}
