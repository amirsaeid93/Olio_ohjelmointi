package org.example;

import java.util.Random;
import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Random random = new Random();


        while (true) {
            int score = 0;

            System.out.println("Welcome to the Multiplication Table Exam!");
            System.out.println("You will be given 10 multiplication problems. Let's begin!\n");


            for (int i = 1; i <= 10; i++) {

                int factor1 = random.nextInt(10) + 1;
                int factor2 = random.nextInt(10) + 1;


                int correctAnswer = factor1 * factor2;


                System.out.print("Problem " + i + ": What is " + factor1 + " x " + factor2 + "? ");
                int userAnswer = scanner.nextInt();


                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + correctAnswer + ".\n");
                }
            }


            System.out.println("Your score: " + score + " out of 10.");


            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication tables!");
                break;
            } else {
                System.out.println("Let's try again. Practice makes perfect!\n");
            }
        }

        scanner.close();
    }
}