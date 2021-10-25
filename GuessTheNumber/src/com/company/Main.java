package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random computerChoice = new Random();
        int rNum = computerChoice.nextInt(20);
        int guesses = 0;
        String no = "n", yes = "y";

        Scanner playerChoice = new Scanner(System.in);
        Scanner playerName = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);

        System.out.println("Hello! What is your name?");
        String pName = playerName.next();

        System.out.println("Well, " + pName + ", I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");


        int pNum = playerChoice.nextInt();

        do{
            if (pNum == 0){
                break;
            }
            else if (pNum < 0 || pNum > 20){
                System.out.println("out of range");
                pNum = playerChoice.nextInt();
            }
            else if (pNum > rNum){
                System.out.println("Your guess is too high.");
                System.out.println("Take a guess.");
                guesses++;
                pNum = playerChoice.nextInt();
            }
            else if (pNum < rNum){
                System.out.println("Your guess is too low.");
                System.out.println("Take a guess.");
                guesses++;
                pNum = playerChoice.nextInt();
            }


        }while(pNum != rNum);

        if(pNum == rNum){
            System.out.println("Good job, " + pName + "! You guessed my number in " + guesses + " guesses!");
            System.out.println("Would you like to play again? (y or n)");

            rNum = computerChoice.nextInt(20);
            guesses = 0;

            String pAgain = playAgain.next();

            while(pAgain.equals(yes)){
                System.out.println("Well, " + pName + ", I am thinking of a number between 1 and 20.");
                System.out.println("Take a guess.");

                pNum = playerChoice.nextInt();

                do{
                    if (pNum == 0){
                        break;
                    }
                    else if (pNum < 0 || pNum > 20){
                        System.out.println("Your guess is out of Range.");
                        pNum = playerChoice.nextInt();
                    }
                    else if (pNum > rNum){
                        System.out.println("Your guess is too high.");
                        System.out.println("Take a guess.");
                        guesses++;
                        pNum = playerChoice.nextInt();
                    }
                    else if (pNum < rNum){
                        System.out.println("Your guess is too low.");
                        System.out.println("Take a guess.");
                        guesses++;
                        pNum = playerChoice.nextInt();
                    }
                }while(pNum != rNum);

                if(pNum == rNum){
                    guesses++;
                    System.out.println("Good job, " + pName + "! You guessed my number in " + guesses + " guesses!");
                    System.out.println("Would you like to play again? (y or n)");

                    rNum = computerChoice.nextInt(20);
                    guesses = 0;

                    pAgain = playAgain.next();
                }
                else break;
            }

            playerChoice.close();
            playerName.close();
            playAgain.close();


        }

    }
}
