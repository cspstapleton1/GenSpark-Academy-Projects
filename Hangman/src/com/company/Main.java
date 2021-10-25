package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] bank = {"car", "cat", "bat", "rat"};

        String blank = "___";
        String wrongChoices = "";
        String no = "n", yes = "y";
        char[] correctLetters = blank.toCharArray();
        int hangman = 0, guessCorrect = 0;
        boolean guess = false;

        Scanner choice = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);

        Random rNum = new Random();
        int n = rNum.nextInt(4);

        String chosenWord = bank[n];
        char[] word = chosenWord.toCharArray();

        while(hangman < 7 && guessCorrect < chosenWord.length()){

            System.out.println(" +---+");
            if(hangman == 0){
                System.out.println("     |");
            }
            else {System.out.println(" O   |");}
            if (hangman <= 1){
                System.out.println("     |");
            }
            else if (hangman == 2){
                System.out.println(" |  |");
            }
            else if (hangman == 3){
                System.out.println("/|   |");
            }
            else if (hangman >= 4){
                System.out.println("/|\\  |");
            }
            if (hangman < 5){
                System.out.println("     |");
            }
            else if(hangman == 5){
                System.out.println(" |   |");
            }
            else if (hangman == 6){
                System.out.println("/|   |");
            }
            System.out.println("Choose a letter.");
            char playerChoice = choice.next().charAt(0);
            for(int i = 0; i < chosenWord.length(); i++){
                if(playerChoice == word[i] && playerChoice != correctLetters[i]){
                    correctLetters[i] = word[i];
                    guess = true;
                    guessCorrect++;
                    System.out.println("Correct!");
                }
                else if(playerChoice == correctLetters[i])
                {
                    System.out.println("You already chose that letter.");
                    guess = true;
                    break;
                }
            }
            if(guess == false){
                hangman++;
                wrongChoices += playerChoice;
            }
            guess = false;
            blank = correctLetters.toString();
            System.out.println("Missed letters: " + wrongChoices);
            System.out.println("Correct letters: " + blank);
        }
        if (guessCorrect == chosenWord.length()){
            System.out.println("You win!");
        }
        else if (hangman == 7){
            System.out.println("You Lose!");
        }
        System.out.println("Play again? (y or n)");
        String pAgain = playAgain.next();
        while(pAgain.equals(yes)){
            hangman = 0;
            guessCorrect = 0;
            n = rNum.nextInt(4);
            blank = "___";
            correctLetters = blank.toCharArray();
            wrongChoices = "";
            chosenWord = bank[n];
            word = chosenWord.toCharArray();


            while(hangman < 7 && guessCorrect < chosenWord.length()){

                System.out.println(" +---+");
                if(hangman == 0){
                    System.out.println("     |");
                }
                else {System.out.println(" O   |");}
                if (hangman <= 1){
                    System.out.println("     |");
                }
                else if (hangman == 2){
                    System.out.println(" |  |");
                }
                else if (hangman == 3){
                    System.out.println("/|   |");
                }
                else if (hangman >= 4){
                    System.out.println("/|\\  |");
                }
                if (hangman < 5){
                    System.out.println("     |");
                }
                else if(hangman == 5){
                    System.out.println(" |   |");
                }
                else if (hangman == 6){
                    System.out.println("/|   |");
                }
                System.out.println("Choose a letter.");
                char playerChoice = choice.next().charAt(0);
                for(int i = 0; i < chosenWord.length(); i++){
                    if(playerChoice == word[i] && playerChoice != correctLetters[i]){
                        correctLetters[i] = word[i];
                        guess = true;
                        guessCorrect++;
                        System.out.println("Correct!");
                    }
                    else if(playerChoice == correctLetters[i])
                    {
                        System.out.println("You already chose that letter.");
                        guess = true;
                        break;
                    }
                }
                if(guess == false){
                    hangman++;
                    wrongChoices += playerChoice;
                }
                guess = false;
                blank = correctLetters.toString();
                System.out.println("Missed letters: " + wrongChoices);
                System.out.println("Correct letters: " + blank);
            }
            if (guessCorrect == chosenWord.length()){
                System.out.println("You win!");
            }
            else if (hangman == 7){
                System.out.println("You Lose!");
            }
            System.out.println("Play again? (y or n)");
            pAgain = playAgain.next();
        }
    }
}
