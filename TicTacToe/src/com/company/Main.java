package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<String> placement = new ArrayList<>();
        String pLetter = "", compLetter = "";
        int pChoice = 0, compChoice = 0;
        Boolean victory = false, failure = false, tie = false,
                emptySpots = false, full = true, compTurn = true,
                playerTurn = true;
        String pAgain = "";
        Random computerChoice = new Random();
        int count = 0;

        Scanner playerLetter = new Scanner(System.in);
        Scanner playerChoice = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);

        for(int i = 0; i < 9; i++){
            placement.add("");
        }


        while(!pLetter.equals("X") && !pLetter.equals("O")) {
            System.out.println("Welcome to Tic-Tac-Toe!\n" +
                    "Do you want to be X or O?");
            pLetter = playerLetter.next();
            if(pLetter.equals("x") || pLetter.equals("X")){pLetter = "X";}
            else if (pLetter.equals("o") || pLetter.equals("O")) {
                pLetter = "O";
            }
            else{
                System.out.println("That's not an X or an O!");
            }
        }

        if(pLetter.equals("X")){
            compLetter = "O";
        }
        else{
            compLetter = "X";
        }

        System.out.println("You Chose: " + pLetter + "\n" + "The computer is: " + compLetter);

        System.out.println("The computer will go first.");

        while(victory == false && failure == false && tie == false) {

            while (compTurn == true) {
                compChoice = computerChoice.nextInt(9);
                if (placement.get(compChoice).equals("")) {
                    placement.set(compChoice, compLetter);
                    compTurn = false;
                }
            }
            System.out.println("Computer chose: " + compChoice);

            if (!placement.get(1).equals("") && placement.get(1).equals(placement.get(0)) && placement.get(1).equals(placement.get(2))) {
                if (placement.get(1).equals(pLetter)) {victory = true;}
                else{failure = true;}
            }
            else if (!placement.get(3).equals("") && placement.get(3).equals(placement.get(0)) && placement.get(3).equals(placement.get(6))) {
                if (placement.get(3).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(5).equals("") && placement.get(5).equals(placement.get(2)) && placement.get(5).equals(placement.get(8))) {
                if (placement.get(5).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(7).equals("") && placement.get(7).equals(placement.get(6)) && placement.get(7).equals(placement.get(8))) {
                if (placement.get(7).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(0)) && placement.get(4).equals(placement.get(8))) {
                if (placement.get(4).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(1)) && placement.get(4).equals(placement.get(7))) {
                if (placement.get(4).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(2)) && placement.get(4).equals(placement.get(6))) {
                if (placement.get(4).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(3)) && placement.get(4).equals(placement.get(5))) {
                if (placement.get(4).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }

            if(victory == true || failure == true || tie == true){
                break;
            }

            while (playerTurn == true) {
                if (emptySpots == false) {
                    for (int j = 0; j < placement.size(); j++) {
                        if (!placement.get(j).equals("")) {count++;}
                    }
                    if (count == 9) {full = true; tie = true; playerTurn = false;}
                    else{
                        count=0;
                    }
                }

                if(tie == true){
                    break;
                }


                System.out.println(placement.get(0) + "|" + placement.get(1) + "|" + placement.get(2));
                System.out.println("_____");
                System.out.println(placement.get(3) + "|" + placement.get(4) + "|" + placement.get(5));
                System.out.println("_____");
                System.out.println(placement.get(6) + "|" + placement.get(7) + "|" + placement.get(8));
                System.out.println("What is your next move? (0-8)");
                pChoice = playerChoice.nextInt();
                if (pChoice < placement.size() && placement.get(pChoice).equals("")) {
                    placement.set(pChoice, pLetter);
                    playerTurn = false;
                }
                else {System.out.println("Not a valid choice.");}
            }

            if (!placement.get(1).equals("") && placement.get(1).equals(placement.get(0)) && placement.get(1).equals(placement.get(2))) {
                if (placement.get(1).equals(pLetter)) {victory = true;}
                else{failure = true;}
            }
            else if (!placement.get(3).equals("") && placement.get(3).equals(placement.get(0)) && placement.get(3).equals(placement.get(6))) {
                if (placement.get(3).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else if (!placement.get(5).equals("") && placement.get(5).equals(placement.get(2)) && placement.get(5).equals(placement.get(8))) {
                if (placement.get(5).equals(pLetter)) {victory = true;}
                else {failure = true;}
                }
            else if (!placement.get(7).equals("") && placement.get(7).equals(placement.get(6)) && placement.get(7).equals(placement.get(8))) {
                    if (placement.get(7).equals(pLetter)) {victory = true;}
                    else {failure = true;}
            }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(0)) && placement.get(4).equals(placement.get(8))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
            }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(1)) && placement.get(4).equals(placement.get(7))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(2)) && placement.get(4).equals(placement.get(6))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
            else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(3)) && placement.get(4).equals(placement.get(5))) {
                if (placement.get(4).equals(pLetter)) {victory = true;}
                else {failure = true;}
            }
            else {
                compTurn = true;
                playerTurn = true;
            }

        }

        System.out.println(placement.get(0) + "|" + placement.get(1) + "|" + placement.get(2));
        System.out.println("_____");
        System.out.println(placement.get(3) + "|" + placement.get(4) + "|" + placement.get(5));
        System.out.println("_____");
        System.out.println(placement.get(6) + "|" + placement.get(7) + "|" + placement.get(8));

        if(tie == true){
            System.out.println("Draw!");
        }
        if(failure == true){
            System.out.println("The computer has beaten you! You lose.");
        }
        else if (victory == true){
            System.out.println("You have beaten the computer! You win.");
        }

        System.out.println("Play again? (yes or no)");
        pAgain = playAgain.next();
        while(pAgain.equals("yes")){
            for(int i = 0; i < 9; i++){
                placement.set(i, "");
            }

            pLetter = ""; compLetter = ""; pChoice = 0; compChoice = 0; victory = false; failure = false; tie = false;
            emptySpots = false; compTurn = true; playerTurn = true;
            count = 0;

            while(!pLetter.equals("X") && !pLetter.equals("O")) {
                System.out.println("Welcome to Tic-Tac-Toe!\n" +
                        "Do you want to be X or O?");
                pLetter = playerLetter.next();
                if(pLetter.equals("x") || pLetter.equals("X")){pLetter = "X";}
                else if (pLetter.equals("o") || pLetter.equals("O")) {
                    pLetter = "O";
                }
                else{
                    System.out.println("That's not an X or an O!");
                }
            }

            if(pLetter.equals("X")){
                compLetter = "O";
            }
            else{
                compLetter = "X";
            }

            System.out.println("You Chose: " + pLetter + "\n" + "The computer is: " + compLetter);

            System.out.println("The computer will go first.");

            while(victory == false && failure == false && tie == false) {

                while (compTurn == true) {
                    compChoice = computerChoice.nextInt(9);
                    if (placement.get(compChoice).equals("")) {
                        placement.set(compChoice, compLetter);
                        compTurn = false;
                    }
                }
                System.out.println("Computer chose: " + compChoice);

                if (!placement.get(1).equals("") && placement.get(1).equals(placement.get(0)) && placement.get(1).equals(placement.get(2))) {
                    if (placement.get(1).equals(pLetter)) {victory = true;}
                    else{failure = true;}
                }
                else if (!placement.get(3).equals("") && placement.get(3).equals(placement.get(0)) && placement.get(3).equals(placement.get(6))) {
                    if (placement.get(3).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(5).equals("") && placement.get(5).equals(placement.get(2)) && placement.get(5).equals(placement.get(8))) {
                    if (placement.get(5).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(7).equals("") && placement.get(7).equals(placement.get(6)) && placement.get(7).equals(placement.get(8))) {
                    if (placement.get(7).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(0)) && placement.get(4).equals(placement.get(8))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(1)) && placement.get(4).equals(placement.get(7))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(2)) && placement.get(4).equals(placement.get(6))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(3)) && placement.get(4).equals(placement.get(5))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }

                if(victory == true || failure == true || tie == true){
                    break;
                }

                while (playerTurn == true) {
                    if (emptySpots == false) {
                        for (int j = 0; j < placement.size(); j++) {
                            if (!placement.get(j).equals("")) {count++;}
                        }
                        if (count == 9) {full = true; tie = true; playerTurn = false;}
                        else{
                            count=0;
                        }
                    }
                    System.out.println(full);

                    if(tie == true){
                        break;
                    }

                    System.out.println(placement.get(0) + "|" + placement.get(1) + "|" + placement.get(2));
                    System.out.println("_____");
                    System.out.println(placement.get(3) + "|" + placement.get(4) + "|" + placement.get(5));
                    System.out.println("_____");
                    System.out.println(placement.get(6) + "|" + placement.get(7) + "|" + placement.get(8));
                    System.out.println("What is your next move? (0-8)");
                    pChoice = playerChoice.nextInt();
                    if (pChoice < placement.size() && placement.get(pChoice).equals("")) {
                        placement.set(pChoice, pLetter);
                        playerTurn = false;
                    }
                    else {System.out.println("Not a valid choice.");}
                }

                if (!placement.get(1).equals("") && placement.get(1).equals(placement.get(0)) && placement.get(1).equals(placement.get(2))) {
                    if (placement.get(1).equals(pLetter)) {victory = true;}
                    else{failure = true;}
                }
                else if (!placement.get(3).equals("") && placement.get(3).equals(placement.get(0)) && placement.get(3).equals(placement.get(6))) {
                    if (placement.get(3).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(5).equals("") && placement.get(5).equals(placement.get(2)) && placement.get(5).equals(placement.get(8))) {
                    if (placement.get(5).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(7).equals("") && placement.get(7).equals(placement.get(6)) && placement.get(7).equals(placement.get(8))) {
                    if (placement.get(7).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(0)) && placement.get(4).equals(placement.get(8))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(1)) && placement.get(4).equals(placement.get(7))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(2)) && placement.get(4).equals(placement.get(6))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else if (!placement.get(4).equals("") && placement.get(4).equals(placement.get(3)) && placement.get(4).equals(placement.get(5))) {
                    if (placement.get(4).equals(pLetter)) {victory = true;}
                    else {failure = true;}
                }
                else {
                    compTurn = true;
                    playerTurn = true;
                }

            }

            System.out.println(placement.get(0) + "|" + placement.get(1) + "|" + placement.get(2));
            System.out.println("_____");
            System.out.println(placement.get(3) + "|" + placement.get(4) + "|" + placement.get(5));
            System.out.println("_____");
            System.out.println(placement.get(6) + "|" + placement.get(7) + "|" + placement.get(8));

            if(tie == true){
                System.out.println("Draw!");
            }
            if(failure == true){
                System.out.println("The computer has beaten you! You lose.");
            }
            else if (victory == true){
                System.out.println("You have beaten the computer! You win.");
            }

            System.out.println("Play again? (yes or no)");
            pAgain = playAgain.next();
        }

    }
}