package org.example;

import java.util.Scanner;

public class MedievalMeasures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        final double LUOTI_PER_GRAM = 13.28;
        final int NAULA_PER_LUOTI = 32;
        final int LEIVISKA_PER_NAULA = 20;


        System.out.print("Weight (g): ");
        double grams = scanner.nextDouble();


        double luoti = grams / LUOTI_PER_GRAM;


        int naula = (int) (luoti / NAULA_PER_LUOTI);
        luoti = luoti % NAULA_PER_LUOTI;

        int leiviska = naula / LEIVISKA_PER_NAULA;
        naula = naula % LEIVISKA_PER_NAULA;


        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n", grams, leiviska, naula, luoti);

        scanner.close();
    }
}
