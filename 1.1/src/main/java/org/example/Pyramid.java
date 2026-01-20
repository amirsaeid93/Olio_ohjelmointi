package org.example;

public class Pyramid {
    public static void main(String[] args) {
        int rows = 4; //The pyramid consist of 4 rows

        for (int i = 1; i <= rows; i++) {
            // Method to print spaces before the asteriskses
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Method to print the asteriskses
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Method to move to the next line
            System.out.println();
        }
    }
}
