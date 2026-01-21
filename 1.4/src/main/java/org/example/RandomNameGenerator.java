package org.example;

import java.util.Random;
import java.util.Scanner;

public class RandomNameGenerator {

    public static void main(String[] args) {

        String[] firstNames = {"James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda", "William", "Elizabeth"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};


        Scanner scanner = new Scanner(System.in);


        System.out.print("How many random names would you like to generate? ");
        int numberOfNames = scanner.nextInt();


        Random random = new Random();


        System.out.println("Generated Names:");
        for (int i = 0; i < numberOfNames; i++) {

            int firstNameIndex = random.nextInt(firstNames.length);
            int lastNameIndex = random.nextInt(lastNames.length);


            String fullName = firstNames[firstNameIndex] + " " + lastNames[lastNameIndex];


            System.out.println(fullName);
        }


        scanner.close();
    }
}
