package org.example;

import java.util.Scanner;

public class BinaryToDecimalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number please: ");
        String binaryString = scanner.nextLine();
        scanner.close();


        int decimal = 0;
        int length = binaryString.length();
        System.out.println("The length is: " + length);

        for (int i = 0; i < length; i++) {

            char bitChar = binaryString.charAt(i);


            if (bitChar == '0' || bitChar == '1') {

                int bit = bitChar - '0';


                decimal = decimal * 2 + bit;
            } else {

                System.out.println("Invalid binary number. Please enter only 0s and 1s.");
                return;
            }
        }


        System.out.println("The decimal equivalent is: " + decimal);
    }
}
