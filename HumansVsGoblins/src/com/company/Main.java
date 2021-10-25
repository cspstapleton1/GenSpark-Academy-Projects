package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Human{
    //hashmap
    HashMap<String, Integer> hStats = new HashMap<>();
}

class Goblin{
    HashMap<String, Integer> gStats = new HashMap<>();
}

class Land{

    ArrayList<String> locations = new ArrayList<>();
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> placement = new ArrayList<>();
        String pChoice = "";
        String grass = "~", hum = "h", gob = "g", pAgain = "", gobDirection = "", humDirection = "";
        int humPlace = 0, gobPlace = 0, dam = 0, GRHP = 0, HRP = 0;
        int compChoice = 0;
        Boolean playMore = true, playerTurn = false, playerAlive = true, goblinAlive = true;
        Scanner playerChoice = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);
        Random computerChoice = new Random();
        Random Damage = new Random();
        Random gStart = new Random();
        Random hStart = new Random();

        Human human = new Human();
        Goblin goblin = new Goblin();
        Land land = new Land();

        human.hStats.put("Level", 1);
        human.hStats.put("HP", 10);
        human.hStats.put("STR", 2);

        goblin.gStats.put("Level", 1);
        goblin.gStats.put("HP", 5);
        goblin.gStats.put("STR", 1);



        for(int i = 0; i < 25; i++) {
            land.locations.add(grass);
        }

        humPlace = hStart.nextInt(25);
        gobPlace = gStart.nextInt(25);

        land.locations.set(humPlace, hum);
        land.locations.set(gobPlace, gob);
        while(playMore == true) {
            System.out.println("Humans versus Goblins!");
            System.out.println(land.locations.get(0) + " " + land.locations.get(1) + " " + land.locations.get(2)
                    + " " + land.locations.get(3) + " " + land.locations.get(4));
            System.out.println(land.locations.get(5) + " " + land.locations.get(6) + " " + land.locations.get(7)
                    + " " + land.locations.get(8) + " " + land.locations.get(9));
            System.out.println(land.locations.get(10) + " " + land.locations.get(11) + " " + land.locations.get(12)
                    + " " + land.locations.get(13) + " " + land.locations.get(14));
            System.out.println(land.locations.get(15) + " " + land.locations.get(16) + " " + land.locations.get(17)
                    + " " + land.locations.get(18) + " " + land.locations.get(19));
            System.out.println(land.locations.get(20) + " " + land.locations.get(21) + " " + land.locations.get(22)
                    + " " + land.locations.get(23) + " " + land.locations.get(24));

            compChoice = computerChoice.nextInt(4);
            if(compChoice == 0){gobDirection = "n";}
            else if(compChoice == 1){gobDirection = "w";}
            else if(compChoice == 2){gobDirection = "e";}
            else if(compChoice == 3){gobDirection = "s";}
            System.out.println("The goblin moves: " + gobDirection);

            land.locations.set(gobPlace, grass);


            if(gobPlace == 0 && gobDirection.equals("n")){
                gobPlace = land.locations.size() - 5;
            }
            else if(gobPlace == 0 && gobDirection.equals("w")){
                gobPlace = land.locations.size() - 1;
            }
            else if(gobPlace == land.locations.size() - 1 && gobDirection.equals("e")){
                gobPlace = 0;
            }
            else if(gobPlace == land.locations.size() - 1 && gobDirection.equals("s")){
                gobPlace = 4;
            }
            else if(gobDirection == "n"){
                if(gobPlace - 5 < 0){gobPlace = gobPlace - 1;}
                else{gobPlace -= 5;}
            }
            else if(gobDirection == "w"){
                gobPlace -= 1;
            }
            else if(gobDirection == "e"){
                gobPlace += 1;
            }
            else if(gobDirection == "s"){
                if(gobPlace + 5 > land.locations.size() - 1){gobPlace += 1;}
                else{gobPlace += 5;}
            }

            if(gobPlace == humPlace){
                HRP = human.hStats.get("HP");
                GRHP = goblin.gStats.get("HP");
                System.out.println("A goblin appears!");
                while(playerAlive == true && goblinAlive == true){
                    System.out.println("The human strikes!");
                    dam = Damage.nextInt(3);
                    //goblin.gStats.put("HP", GRHP - human.hStats.get("STR") * dam);
                    GRHP = GRHP - human.hStats.get("STR") * dam;
                    System.out.println("The human dealt: " + human.hStats.get("STR") * dam);
                    if(GRHP < 1){
                        goblinAlive = false;
                        System.out.println("The goblin was defeated!");
                        break;
                    }
                    System.out.println("The goblin strikes!");
                    dam = Damage.nextInt(3);
                    //human.hStats.put("HP", HRP - goblin.gStats.get("STR") * dam);
                    HRP = HRP - goblin.gStats.get("STR") * dam;
                    System.out.println("The goblin dealt: " + human.hStats.get("STR") * dam);
                    if(HRP < 1){
                        playerAlive = false;
                        System.out.println("The human died!");
                        playerTurn = false;
                        break;
                    }
                }
            }
            else {
                land.locations.set(gobPlace, gob);
                playerTurn = true;
            }

            if(playerTurn == true){
                while(!humDirection.equals("n") && !humDirection.equals("w") &&
                        !humDirection.equals("e") && !humDirection.equals("s")){
                    System.out.println("n? w? e? s? Pick a direction!");
                    humDirection = playerChoice.next();
                    if(!humDirection.equals("n") && !humDirection.equals("w") &&
                            !humDirection.equals("e") && !humDirection.equals("s")){
                        System.out.println("Sorry bud, we don't accept capital letters " +
                                "or any non-cardinal direction.");
                    }
                }

                if(humPlace == 0 && humDirection.equals("n")){
                    humPlace = land.locations.size() - 5;
                }
                else if(humPlace == 0 && humDirection.equals("w")){
                    humPlace = land.locations.size() - 1;
                }
                else if(humPlace == land.locations.size() - 1 && humDirection.equals("e")){
                    humPlace = 0;
                }
                else if(humPlace == land.locations.size() - 1 && humDirection.equals("s")){
                    humPlace = 4;
                }
                else if(humDirection == "n"){
                    if(humPlace - 5 < 0){humPlace = humPlace - 1;}
                    else{humPlace -= 5;}
                }
                else if(humDirection == "w"){
                    humPlace -= 1;
                }
                else if(humDirection == "e"){
                    humPlace += 1;
                }
                else if(humDirection == "s"){
                    if(humPlace + 5 > land.locations.size() - 1){gobPlace += 1;}
                    else{humPlace += 5;}
                }

                if(gobPlace == humPlace){
                    HRP = human.hStats.get("HP");
                    GRHP = goblin.gStats.get("HP");
                    System.out.println("A goblin appears!");
                    while(playerAlive == true && goblinAlive == true){
                        System.out.println("The human strikes!");
                        dam = Damage.nextInt(3);
                        //goblin.gStats.put("HP", GRHP - human.hStats.get("STR") * dam);
                        GRHP = GRHP - human.hStats.get("STR") * dam;
                        System.out.println("The human dealt: " + human.hStats.get("STR") * dam);
                        if(GRHP < 1){
                            goblinAlive = false;
                            System.out.println("The goblin was defeated!");
                            break;
                        }
                        System.out.println("The goblin strikes!");
                        dam = Damage.nextInt(3);
                        //human.hStats.put("HP", HRP - goblin.gStats.get("STR") * dam);
                        HRP = HRP - goblin.gStats.get("STR") * dam;
                        System.out.println("The goblin dealt: " + human.hStats.get("STR") * dam);
                        if(HRP < 1){
                            playerAlive = false;
                            System.out.println("The human died!");
                            playerTurn = false;
                            break;

                        }
                    }
                }
                else {
                    land.locations.set(humPlace, gob);
                    playerTurn = false;
                }
            }
            else if(playerAlive == false) {
                System.out.println("You lost. Play again? (y or n)");
                while (!pAgain.equals("y") && !pAgain.equals("n")) {
                    pAgain = playAgain.next();
                    if (pAgain.equals("y")) {
                        HRP = 10;
                        GRHP = 5;
                        playMore = true;
                    } else if (pAgain.equals("n")) {
                        playMore = false;
                    }
                }
                pAgain = "";
            }
            else if(goblinAlive == false){
                System.out.println("You won! Fight again? (y or n)");
                while (!pAgain.equals("y") && !pAgain.equals("n")) {
                    pAgain = playAgain.next();
                    if (pAgain.equals("y")) {
                        HRP = 10;
                        GRHP = 5;
                        playMore = true;
                    } else if (pAgain.equals("n")) {
                        playMore = false;
                    }
                }
                pAgain = "";
            }
        }
    }
}
