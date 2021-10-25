package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");

        Scanner choice = new Scanner(System.in);

        int playerChoice = choice.nextInt();

        if (playerChoice == 1){
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
            choice.close();
        }
        else if (playerChoice == 2){
            System.out.println("You approach the cave...");
            System.out.println("It is well lit and homely...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Welcomes you to his humble abode. He offers you a meal and a share of his gold.");
            choice.close();
        }
        else if (playerChoice == 0){
            choice.close();
        }
        else{
            System.out.println(playerChoice + " isn't a cave.");
            playerChoice = choice.nextInt();
        }
    }
}
