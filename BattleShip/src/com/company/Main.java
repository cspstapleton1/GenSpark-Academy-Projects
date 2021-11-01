package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



/*
Your project should use inheritance where the ship is an abstract base class
from which all the other ships inherit from. Your project should use encapsulation
where every field is private, the fields are only accessible through getters and setters.
Everything should be an object, including the board itself.
 */


abstract class Ship{
    ArrayList<Integer> test = new ArrayList<>();

}


class Carrier extends Ship{
    int size = 5;

}

class Battleship extends Ship{
    int size = 4;
}

class Destroyer extends Ship{
    int size = 3;
}

class Submarine extends Ship{
    int size = 3;
}

class PatrolBoat extends Ship{
    int size = 2;
}

class Board{
    ArrayList<String> board1 = new ArrayList<>();
    ArrayList<String> board2 = new ArrayList<>();

    Scanner player1Name = new Scanner(System.in);
    Scanner player2Name = new Scanner(System.in);
    Scanner coordinateX = new Scanner(System.in);
    Scanner coordinateY = new Scanner(System.in);
    Scanner horizon = new Scanner(System.in);

    private String p1Name, p2Name, HorV;

    private Boolean p1turn, p2turn, horizontal, hit, placed, overlap, p1Lose, p2Lose;
    private int size = 0, place = 0, cX = 0, cY = 0, CarrierHP, BattleshipHP, DestroyerHP,
            SubmarineHP, PatrolBoatHP, ShipsDown;

    public int getPlace(){return place;}
    public void setPlace(int newPlace){place = newPlace;}

    public int getCX(){return cX;}
    public void setCX(int newCX){cX = newCX;}

    public int getCY(){return cY;}
    public void setCY(int newCY){cY = newCY;}

    public int getCarrierHP(){return CarrierHP;}
    public void setCarrierHP(int newCarrierHP){cY = newCarrierHP;}

    public int getBattleshipHP(){return BattleshipHP;}
    public void setBattleshipHP(int newBattleshipHP){cY = newBattleshipHP;}

    public int getDestroyerHP(){return DestroyerHP;}
    public void setDestroyerHP(int newDestroyerHP){cY = newDestroyerHP;}

    public int getSubmarineHP(){return SubmarineHP;}
    public void setSubmarineHP(int newSubmarineHP){cY = newSubmarineHP;}

    public int getPatrolBoatHP(){return cY;}
    public void setPatrolBoatHP(int newPatrolBoatHP){cY = newPatrolBoatHP;}
    public int getShipsDown(){return cY;}
    public void setShipsDown(int newShipsDown){cY = newShipsDown;}

    public String getP1Name(){return p1Name;}
    public void setP1Name(String newP1Name){p1Name = newP1Name;}

    public String getP2Name(){return p2Name;}
    public void setP2Name(String newP2Name){p2Name = newP2Name;}

    public String getHorV(){return HorV;}
    public void setHorV(String newHorV){HorV = newHorV;}

    public boolean getHorizontal(){return horizontal;}
    public void setHorizontal(Boolean newHorizontal){horizontal = newHorizontal;}

    public boolean getP1turn(){return p1turn;}
    public void setP1turn(Boolean newP1turn){p1turn = newP1turn;}

    public boolean getP1Lose(){return p1Lose;}
    public void setP1Lose(Boolean newP1Lose){p1Lose = newP1Lose;}

    public boolean getP2turn(){return p2turn;}
    public void setP2turn(Boolean newP2turn){p2turn = newP2turn;}

    public boolean getP2Lose(){return p2Lose;}
    public void setP2Lose(Boolean newP2Lose){p2Lose = newP2Lose;}

    public boolean getHit(){return hit;}
    public void setHit(Boolean newHit){hit = newHit;}

    public boolean getPlaced(){return placed;}
    public void setPlaced(Boolean newPlaced){placed = newPlaced;}

    public boolean getOverlap(){return overlap;}
    public void setOverlap(Boolean newOverlap){overlap = newOverlap;}

}

public class Main{

    public static void main(String[] args) {
        // write your code here

        int size = 0;

        Board b1 = new Board();
        Board b2 = new Board();

        System.out.println("player 1 enter name: ");
        b1.setP1Name(b1.player1Name.next());
        System.out.println("player 2 enter name: ");
        b2.setP2Name(b2.player2Name.next());


        b1.setOverlap(false);
        b1.setHorizontal(true);
        b2.setOverlap(false);
        b2.setHorizontal(true);

        for(int i = 1; i <= 82; i++){
            b1.board1.add("~");
            b1.board2.add("~");
        }
        for(int i = 1; i <= 82; i++){
            b2.board1.add("~");
            b2.board2.add("~");
        }

        b1.setPlaced(false);
        b2.setPlaced(false);

        while(!b1.getPlaced()) {
            System.out.println("player 1 enter coordinates for the carrier: ");
            size = 5;
            while(b1.getCX() < 1){
            b1.setCX(b1.coordinateX.nextInt());}
            while(b1.getCY() < 1) {b1.setCY(b1.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b1.setHorV(b1.horizon.next());
            if (b1.getHorV().equals("h") || b1.getHorV().equals("H")) {
                b1.setHorizontal(true);
            } else {
                b1.setHorizontal(false);
            }
            if(b1.getCY() == 1){
            b1.setPlace(b1.getCX());}
            else{
                b1.setPlace(b1.getCX() + ((b1.getCY() - 1) * 9));
            }
            if(b1.getPlace() < 82) {
                if (b1.board1.get(b1.getPlace()).equals("~")) {
                    if (b1.getHorizontal() == true) {
                        if ((b1.getPlace() % 10) + 5 >= 10) {
                            b1.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                b1.board1.set(b1.getPlace() + i, "C");
                            }
                            b1.setPlaced(true);
                        }
                    } else {
                        if ((b1.getPlace() + 10 * size) > 81) {
                            b1.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                b1.board1.set(b1.getPlace() + (i * 10), "C");
                            }
                            b1.setPlaced(true);
                        }
                    }
                } else {
                    b1.setPlaced(false);
                }
            }
        }
        b1.setPlaced(false);
        b1.setCX(0);
        b1.setCY(0);
        b1.setHorV("");

        while(!b1.getPlaced()) {
            System.out.println("player 1 enter coordinates for the battleship ");
            size = 4;
            while(b1.getCX() < 1){
                b1.setCX(b1.coordinateX.nextInt());}
            while(b1.getCY() < 1) {b1.setCY(b1.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b1.setHorV(b1.horizon.next());
            if (b1.getHorV().equals("h") || b1.getHorV().equals("H")) {
                b1.setHorizontal(true);
            } else {
                b1.setHorizontal(false);
            }
            if(b1.getCY() == 1){
                b1.setPlace(b1.getCX());}
            else{
                b1.setPlace(b1.getCX() + ((b1.getCY() - 1) * 9));
            }
            if(b1.getPlace() < 82) {
                if (b1.board1.get(b1.getPlace()).equals("~")) {
                    if (b1.getHorizontal()) {
                        System.out.println("horizontal");
                        if ((b1.getPlace() % 10) + size >= 10) {b1.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b1.board1.get(b1.getPlace() + i).equals("C")){b1.setOverlap(true);}
                            }
                            if(!b1.getOverlap()){
                                for (int i = 0; i < size; i++) {b1.board1.set(b1.getPlace() + i, "B");}
                                b1.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b1.getPlace() + 10 * size) > 81) {
                            b1.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b1.board1.get(i * 10).equals("C")){
                                    b1.setOverlap(true);
                                }
                            }
                            if(!b1.getOverlap()) {
                                for (int i = 0; i < size; i++) {
                                    b1.board1.set(b1.getPlace() + (i * 10), "B");
                                }
                                b1.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b1.setPlaced(false);
                }
            }
            b1.setCX(0);
            b1.setCY(0);
        }
        b1.setPlaced(false);
        b1.setCX(0);
        b1.setCY(0);
        b1.setHorV("");

        while(b1.getPlaced() == false) {
            System.out.println("player 1 enter coordinates for the destroyer: ");
            size = 3;
            while(b1.getCX() < 1){
                b1.setCX(b1.coordinateX.nextInt());}
            while(b1.getCY() < 1) {b1.setCY(b1.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b1.setHorV(b1.horizon.next());
            if (b1.getHorV().equals("h") || b1.getHorV().equals("H")) {
                b1.setHorizontal(true);
            } else {
                b1.setHorizontal(false);
            }
            if(b1.getCY() == 1){
                b1.setPlace(b1.getCX());}
            else{
                b1.setPlace(b1.getCX() + ((b1.getCY() - 1) * 9));
            }
            if(b1.getPlace() < 82) {
                if (b1.board1.get(b1.getPlace()).equals("~")) {
                    if (b1.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b1.getPlace() % 10) + size >= 10) {b1.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b1.board1.get(b1.getPlace() + i).equals("C") ||
                                        b1.board1.get(b1.getPlace() + i).equals("B")){b1.setOverlap(true);}
                            }
                            if(b1.getOverlap() == false){
                                for (int i = 0; i < size; i++) {b1.board1.set(b1.getPlace() + i, "D");}
                                b1.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b1.getPlace() + 10 * size) > 81) {
                            b1.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b1.board1.get(i * 10).equals("C") || b1.board1.get(i * 10).equals("B")){
                                    b1.setOverlap(true);
                                }
                            }
                            if(b1.getOverlap() == false) {
                                for (int i = 0; i < size; i++) {
                                    b1.board1.set(b1.getPlace() + (i * 10), "D");
                                }
                                b1.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b1.setPlaced(false);
                }
            }
            b1.setCX(0);
            b1.setCY(0);
        }
        b1.setPlaced(false);
        b1.setCX(0);
        b1.setCY(0);
        b1.setHorV("");

        while(b1.getPlaced() == false) {
            System.out.println("player 1 enter coordinates for the submarine: ");
            size = 2;
            while(b1.getCX() < 1){
                b1.setCX(b1.coordinateX.nextInt());}
            while(b1.getCY() < 1) {b1.setCY(b1.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b1.setHorV(b1.horizon.next());
            if (b1.getHorV().equals("h") || b1.getHorV().equals("H")) {
                b1.setHorizontal(true);
            } else {
                b1.setHorizontal(false);
            }
            if(b1.getCY() == 1){
                b1.setPlace(b1.getCX());}
            else{
                b1.setPlace(b1.getCX() + ((b1.getCY() - 1) * 9));
            }
            if(b1.getPlace() < 82) {
                if (b1.board1.get(b1.getPlace()).equals("~")) {
                    if (b1.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b1.getPlace() % 10) + size >= 10) {b1.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b1.board1.get(b1.getPlace() + i).equals("C") ||
                                        b1.board1.get(b1.getPlace() + i).equals("B") ||
                                        b1.board1.get(b1.getPlace() + i).equals("D")){b1.setOverlap(true);}
                            }
                            if(b1.getOverlap() == false){
                                for (int i = 0; i < size; i++) {b1.board1.set(b1.getPlace() + i, "S");}
                                b1.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b1.getPlace() + 10 * size) > 81) {
                            b1.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b1.board1.get(i * 10).equals("C") ||
                                        b1.board1.get(i * 10).equals("B") ||
                                        b1.board1.get(i * 10).equals("D")){
                                    b1.setOverlap(true);
                                }
                            }
                            if(b1.getOverlap() == false) {
                                for (int i = 0; i < size; i++) {
                                    b1.board1.set(b1.getPlace() + (i * 10), "S");
                                }
                                b1.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b1.setPlaced(false);
                }
            }
            b1.setCX(0);
            b1.setCY(0);
        }
        b1.setPlaced(false);
        b1.setCX(0);
        b1.setCY(0);
        b1.setHorV("");

        while(b1.getPlaced() == false) {
            System.out.println("player 1 enter coordinates for the Patrol Boat: ");
            size = 2;
            while(b1.getCX() < 1){
                b1.setCX(b1.coordinateX.nextInt());}
            while(b1.getCY() < 1) {b1.setCY(b1.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b1.setHorV(b1.horizon.next());
            if (b1.getHorV().equals("h") || b1.getHorV().equals("H")) {
                b1.setHorizontal(true);
            } else {
                b1.setHorizontal(false);
            }
            if(b1.getCY() == 1){
                b1.setPlace(b1.getCX());}
            else{
                b1.setPlace(b1.getCX() + ((b1.getCY() - 1) * 9));
            }
            if(b1.getPlace() < 82) {
                if (b1.board1.get(b1.getPlace()).equals("~")) {
                    if (b1.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b1.getPlace() % 10) + size >= 10) {b1.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b1.board1.get(b1.getPlace() + i).equals("C") ||
                                        b1.board1.get(b1.getPlace() + i).equals("B") ||
                                        b1.board1.get(b1.getPlace() + i).equals("D") ||
                                        b1.board1.get(b1.getPlace() + i).equals("S")){b1.setOverlap(true);}
                            }
                            if(b1.getOverlap() == false){
                                for (int i = 0; i < size; i++) {b1.board1.set(b1.getPlace() + i, "P");}
                                b1.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b1.getPlace() + 10 * size) > 81) {
                            b1.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b1.board1.get(i * 10).equals("C") ||
                                        b1.board1.get(i * 10).equals("B") ||
                                        b1.board1.get(i * 10).equals("D") ||
                                        b1.board1.get(i * 10).equals("S")){
                                    b1.setOverlap(true);
                                }
                            }
                            if(b1.getOverlap() == false) {
                                for (int i = 0; i < size; i++) {
                                    b1.board1.set(b1.getPlace() + (i * 10), "P");
                                }
                                b1.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b1.setPlaced(false);
                }
            }
            b1.setCX(0);
            b1.setCY(0);
        }
        b1.setPlaced(false);
        b1.setCX(0);
        b1.setCY(0);
        b1.setHorV("");

        System.out.println("  1 2 3 4 5 6 7 8 9");
        for(int i = 1; i < 82; i++){
            if(i % 9 == 1){System.out.print((i / 10) + 1);}
            if(i % 9 != 0){System.out.print(" " + b1.board1.get(i));}
            else{System.out.println(" " + b1.board1.get(i));}
        }


        while(!b2.getPlaced()) {
            System.out.println("player 2 enter coordinates for the carrier: ");
            size = 5;
            while(b2.getCX() < 1){
                b2.setCX(b2.coordinateX.nextInt());}
            while(b2.getCY() < 1) {b2.setCY(b2.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b2.setHorV(b2.horizon.next());
            if (b2.getHorV().equals("h") || b2.getHorV().equals("H")) {
                b2.setHorizontal(true);
            } else {
                b2.setHorizontal(false);
            }
            if(b2.getCY() == 1){
                b2.setPlace(b2.getCX());}
            else{
                b2.setPlace(b2.getCX() + ((b2.getCY() - 1) * 9));
            }
            if(b2.getPlace() < 82) {
                if (b2.board1.get(b2.getPlace()).equals("~")) {
                    if (b2.getHorizontal()) {
                        if ((b2.getPlace() % 10) + 5 >= 10) {
                            b2.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                b2.board1.set(b2.getPlace() + i, "C");
                            }
                            b2.setPlaced(true);
                        }
                    } else {
                        if ((b2.getPlace() + 10 * size) > 81) {
                            b2.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                b2.board1.set(b2.getPlace() + (i * 10), "C");
                            }
                            b2.setPlaced(true);
                        }
                    }
                } else {
                    b2.setPlaced(false);
                }
            }
        }
        b2.setPlaced(false);
        b2.setCX(0);
        b2.setCY(0);
        b2.setHorV("");

        while(!b2.getPlaced()) {
            System.out.println("player 2 enter coordinates for the battleship ");
            size = 4;
            while(b2.getCX() < 1){
                b2.setCX(b2.coordinateX.nextInt());}
            while(b2.getCY() < 1) {b2.setCY(b2.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b2.setHorV(b2.horizon.next());
            if (b2.getHorV().equals("h") || b2.getHorV().equals("H")) {
                b2.setHorizontal(true);
            } else {
                b2.setHorizontal(false);
            }
            if(b2.getCY() == 1){
                b2.setPlace(b2.getCX());}
            else{
                b2.setPlace(b2.getCX() + ((b2.getCY() - 1) * 9));
            }
            if(b2.getPlace() < 82) {
                if (b2.board1.get(b2.getPlace()).equals("~")) {
                    if (b2.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b2.getPlace() % 10) + size >= 10) {
                            b2.setPlaced(false);
                            System.out.println("too far");
                        }
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b2.board1.get(b2.getPlace() + i).equals("C")){b2.setOverlap(true);}
                            }
                            if(!b2.getOverlap()){
                                for (int i = 0; i < size; i++) {b2.board1.set(b2.getPlace() + i, "B");}
                                b2.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b2.getPlace() + 10 * size) > 81) {
                            b2.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b2.board1.get(i * 10).equals("C")){
                                    b2.setOverlap(true);
                                }
                            }
                            if(!b2.getOverlap()) {
                                for (int i = 0; i < size; i++) {
                                    b2.board1.set(b2.getPlace() + (i * 10), "B");
                                }
                                b2.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b2.setPlaced(false);
                }
            }
            b2.setCX(0);
            b2.setCY(0);
        }
        b2.setPlaced(false);
        b2.setCX(0);
        b2.setCY(0);
        b2.setHorV("");

        while(!b2.getPlaced()) {
            System.out.println("player 1 enter coordinates for the destroyer: ");
            size = 3;
            while(b2.getCX() < 1){
                b2.setCX(b2.coordinateX.nextInt());}
            while(b2.getCY() < 1) {b2.setCY(b2.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b2.setHorV(b2.horizon.next());
            if (b2.getHorV().equals("h") || b2.getHorV().equals("H")) {
                b2.setHorizontal(true);
            } else {
                b2.setHorizontal(false);
            }
            if(b2.getCY() == 1){
                b2.setPlace(b2.getCX());}
            else{
                b2.setPlace(b2.getCX() + ((b2.getCY() - 1) * 9));
            }
            if(b2.getPlace() < 82) {
                if (b2.board1.get(b2.getPlace()).equals("~")) {
                    if (b2.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b2.getPlace() % 10) + size >= 10) {b2.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b2.board1.get(b2.getPlace() + i).equals("C") ||
                                        b2.board1.get(b2.getPlace() + i).equals("B")){b2.setOverlap(true);}
                            }
                            if(b2.getOverlap() == false){
                                for (int i = 0; i < size; i++) {b2.board1.set(b2.getPlace() + i, "D");}
                                b2.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b2.getPlace() + 10 * size) > 81) {
                            b2.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b2.board1.get(i * 10).equals("C") ||
                                        b2.board1.get(i * 10).equals("B")){
                                    b2.setOverlap(true);
                                }
                            }
                            if(b2.getOverlap() == false) {
                                for (int i = 0; i < size; i++) {
                                    b2.board1.set(b2.getPlace() + (i * 10), "D");
                                }
                                b2.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b2.setPlaced(false);
                }
            }
            b2.setCX(0);
            b2.setCY(0);
        }
        b2.setPlaced(false);
        b2.setCX(0);
        b2.setCY(0);
        b2.setHorV("");

        while(!b2.getPlaced()) {
            System.out.println("player 1 enter coordinates for the submarine: ");
            size = 2;
            while(b2.getCX() < 1){
                b2.setCX(b2.coordinateX.nextInt());}
            while(b2.getCY() < 1) {b2.setCY(b2.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b2.setHorV(b2.horizon.next());
            if (b2.getHorV().equals("h") || b2.getHorV().equals("H")) {
                b2.setHorizontal(true);
            } else {
                b2.setHorizontal(false);
            }
            if(b2.getCY() == 1){
                b2.setPlace(b2.getCX());}
            else{
                b2.setPlace(b2.getCX() + ((b2.getCY() - 1) * 9));
            }
            if(b2.getPlace() < 82) {
                if (b2.board1.get(b2.getPlace()).equals("~")) {
                    if (b2.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b2.getPlace() % 10) + size >= 10) {b2.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b2.board1.get(b2.getPlace() + i).equals("C") ||
                                        b2.board1.get(b2.getPlace() + i).equals("B") ||
                                        b2.board1.get(b2.getPlace() + i).equals("D")){b2.setOverlap(true);}
                            }
                            if(b2.getOverlap() == false){
                                for (int i = 0; i < size; i++) {b2.board1.set(b2.getPlace() + i, "S");}
                                b2.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b2.getPlace() + 10 * size) > 81) {
                            b2.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b2.board1.get(i * 10).equals("C") ||
                                        b2.board1.get(i * 10).equals("B") ||
                                        b2.board1.get(i * 10).equals("D")){
                                    b2.setOverlap(true);
                                }
                            }
                            if(b2.getOverlap() == false) {
                                for (int i = 0; i < size; i++) {
                                    b2.board1.set(b2.getPlace() + (i * 10), "S");
                                }
                                b2.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b2.setPlaced(false);
                }
            }
            b2.setCX(0);
            b2.setCY(0);
        }
        b2.setPlaced(false);
        b2.setCX(0);
        b2.setCY(0);
        b2.setHorV("");

        while(b2.getPlaced() == false) {
            System.out.println("player 1 enter coordinates for the Patrol Boat: ");
            size = 2;
            while(b2.getCX() < 1){
                b2.setCX(b2.coordinateX.nextInt());}
            while(b2.getCY() < 1) {b2.setCY(b2.coordinateY.nextInt());}
            System.out.println("Place horizontally or vertically (h or v)?");
            b2.setHorV(b2.horizon.next());
            if (b2.getHorV().equals("h") || b2.getHorV().equals("H")) {
                b2.setHorizontal(true);
            } else {
                b2.setHorizontal(false);
            }
            if(b2.getCY() == 1){
                b2.setPlace(b2.getCX());}
            else{
                b2.setPlace(b2.getCX() + ((b2.getCY() - 1) * 9));
            }
            if(b2.getPlace() < 82) {
                if (b2.board1.get(b2.getPlace()).equals("~")) {
                    if (b2.getHorizontal() == true) {
                        System.out.println("horizontal");
                        if ((b2.getPlace() % 10) + size >= 10) {b2.setPlaced(false); System.out.println("too far");}
                        else {
                            for (int i = 0; i < size; i++) {
                                if (b2.board1.get(b2.getPlace() + i).equals("C") ||
                                        b2.board1.get(b2.getPlace() + i).equals("B") ||
                                        b2.board1.get(b2.getPlace() + i).equals("D") ||
                                        b2.board1.get(b2.getPlace() + i).equals("S")){b2.setOverlap(true);}
                            }
                            if(b2.getOverlap() == false){
                                for (int i = 0; i < size; i++) {b2.board1.set(b2.getPlace() + i, "P");}
                                b2.setPlaced(true);
                                System.out.println("No overlap");
                            }
                            else{System.out.println("Overlap");}
                        }
                    } else {
                        System.out.println("vertical");
                        if ((b2.getPlace() + 10 * size) > 81) {
                            b2.setPlaced(false);
                        } else {
                            for (int i = 0; i < size; i++) {
                                if(b2.board1.get(i * 10).equals("C") ||
                                        b2.board1.get(i * 10).equals("B") ||
                                        b2.board1.get(i * 10).equals("D") ||
                                        b2.board1.get(i * 10).equals("S")){
                                    b2.setOverlap(true);
                                }
                            }
                            if(b2.getOverlap() == false) {
                                for (int i = 0; i < size; i++) {
                                    b2.board1.set(b2.getPlace() + (i * 10), "P");
                                }
                                b2.setPlaced(true);
                            }
                            else{
                                System.out.println("Overlap");
                            }
                        }
                    }
                } else {
                    b2.setPlaced(false);
                }
            }
            b2.setCX(0);
            b2.setCY(0);
        }
        b2.setPlaced(false);
        b2.setCX(0);
        b2.setCY(0);
        b2.setHorV("");

        System.out.println("  1 2 3 4 5 6 7 8 9");
        for(int i = 1; i < 82; i++){
            if(i % 9 == 1){System.out.print((i / 10) + 1);}
            if(i % 9 != 0){System.out.print(" " + b2.board1.get(i));}
            else{System.out.println(" " + b2.board1.get(i));}
        }

        b1.setP1Lose(false);
        b2.setP2Lose(false);
        b1.setP1turn(true);
        b2.setP2turn(false);

        b1.setShipsDown(0);
        b2.setShipsDown(0);

        b1.setCarrierHP(5);
        b1.setBattleshipHP(4);
        b1.setDestroyerHP(3);
        b1.setSubmarineHP(2);
        b1.setPatrolBoatHP(2);

        b2.setCarrierHP(5);
        b2.setBattleshipHP(4);
        b2.setDestroyerHP(3);
        b2.setSubmarineHP(2);
        b2.setPatrolBoatHP(2);

        /*
        while(p1Lose == false && p2Lose == false){
        p1 is shown an empty grid: their attacks check b2.board1 and update b2.board2
        p2 is vice versa.
        player turn goes until they pick a valid (~) spot, or for p2 if p1 wins.
        game ends when p1 or p2 loses 5 ships.
        }
         */
        while(!b1.getP1Lose() && !b2.getP2Lose()){

            while(b1.getP1turn()){
                while(!b1.getPlaced()) {
                    System.out.println("Enter coordinates Player 1!");
                    while (b1.getCX() < 1) {
                        b1.setCX(b1.coordinateX.nextInt());
                    }
                    while (b1.getCY() < 1) {
                        b1.setCY(b1.coordinateY.nextInt());
                    }
                    if (b1.getCY() == 1) {
                        b1.setPlace(b1.getCX());
                    } else {
                        b1.setPlace(b1.getCX() + ((b1.getCY() - 1) * 9));
                    }
                    if(b2.board1.get(b1.getPlace()).equals("~")){
                        b2.board2.set(b1.getPlace(), "m");
                        b1.setPlaced(true);
                    }
                    else if (b2.board1.get(b1.getPlace()).equals("C") ||
                            b2.board1.get(b1.getPlace()).equals("B") ||
                            b2.board1.get(b1.getPlace()).equals("D") ||
                            b2.board1.get(b1.getPlace()).equals("S") ||
                            b2.board1.get(b1.getPlace()).equals("P")) {
                        b2.board2.set(b1.getPlace(), "x");
                        if (b2.board1.get(b1.getPlace()).equals("C")) {
                            b1.setCarrierHP(b1.getCarrierHP() - 1);
                            if (b2.getCarrierHP() == 0) {
                                System.out.println("You sunk " + b2.getP2Name() + "'s Carrier!");
                                b2.setShipsDown(b2.getShipsDown() + 1);
                            }
                        }
                        if (b2.board1.get(b1.getPlace()).equals("B")) {
                            b2.setCarrierHP(b2.getBattleshipHP() - 1);
                            if (b2.getBattleshipHP() == 0) {
                                System.out.println("You sunk " + b2.getP2Name() + "'s Battleship!");
                                b2.setShipsDown(b2.getShipsDown() + 1);
                            }
                        }
                        if(b2.board1.get(b1.getPlace()).equals("D")) {
                            b2.setDestroyerHP(b2.getDestroyerHP() - 1);
                            if (b2.getDestroyerHP() == 0) {
                                System.out.println("You sunk " + b2.getP2Name() + "'s Destroyer!");
                                b2.setShipsDown(b2.getShipsDown() + 1);
                            }
                        }
                        if(b2.board1.get(b1.getPlace()).equals("S")) {
                            b2.setSubmarineHP(b2.getSubmarineHP() - 1);
                            if (b2.getSubmarineHP() == 0) {
                                System.out.println("You sunk " + b2.getP2Name() + "'s Submarine!");
                                b2.setShipsDown(b2.getShipsDown() + 1);
                            }
                        }
                        if(b2.board1.get(b1.getPlace()).equals("P")) {
                            b2.setPatrolBoatHP(b2.getPatrolBoatHP() - 1);
                            if (b2.getPatrolBoatHP() == 0) {
                                System.out.println("You sunk " + b2.getP2Name() + "'s Patrol Boat!");
                                b2.setShipsDown(b2.getShipsDown() + 1);
                            }
                        }
                        b1.setPlaced(true);
                    }
                    else{
                        System.out.println("You've already fired there.");
                        b1.setPlaced(false);
                    }
                }
                if(b2.getShipsDown() == 5){
                    b2.setP2Lose(true);
                    b1.setP1turn(false);
                    b2.setP2turn(false);
                }
                else {
                    b1.setP1turn(false);
                    b2.setP2turn(true);
                }
            }

            while(b2.getP2turn()){
                while(!b2.getPlaced()) {
                    System.out.println("Enter coordinates Player 2!");
                    while (b2.getCX() < 1) {
                        b2.setCX(b2.coordinateX.nextInt());
                    }
                    while (b2.getCY() < 1) {
                        b2.setCY(b2.coordinateY.nextInt());
                    }
                    if (b2.getCY() == 1) {
                        b2.setPlace(b2.getCX());
                    } else {
                        b2.setPlace(b2.getCX() + ((b2.getCY() - 1) * 9));
                    }
                    if(b2.board1.get(b2.getPlace()).equals("~")){
                        b2.board2.set(b2.getPlace(), "m");
                        b2.setPlaced(true);
                    }
                    else if (b1.board1.get(b2.getPlace()).equals("C") ||
                            b1.board1.get(b2.getPlace()).equals("B") ||
                            b1.board1.get(b2.getPlace()).equals("D") ||
                            b1.board1.get(b2.getPlace()).equals("S") ||
                            b1.board1.get(b2.getPlace()).equals("P")){
                        b1.board2.set(b2.getPlace(), "x");
                        b2.setPlaced(true);
                        if (b1.board1.get(b2.getPlace()).equals("C")) {
                            b1.setCarrierHP(b1.getCarrierHP() - 1);
                            if (b1.getCarrierHP() == 0) {
                                System.out.println("You sunk " + b1.getP1Name() + "'s Carrier!");
                                b1.setShipsDown(b1.getShipsDown() + 1);
                            }
                        }
                        if (b1.board1.get(b2.getPlace()).equals("B")) {
                            b1.setCarrierHP(b1.getBattleshipHP() - 1);
                            if (b1.getBattleshipHP() == 0) {
                                System.out.println("You sunk " + b2.getP2Name() + "'s Battleship!");
                                b1.setShipsDown(b1.getShipsDown() + 1);
                            }
                        }
                        if(b1.board1.get(b2.getPlace()).equals("D")) {
                            b1.setDestroyerHP(b1.getDestroyerHP() - 1);
                            if (b1.getDestroyerHP() == 0) {
                                System.out.println("You sunk " + b1.getP1Name() + "'s Destroyer!");
                                b1.setShipsDown(b1.getShipsDown() + 1);
                            }
                        }
                        if(b1.board1.get(b2.getPlace()).equals("S")) {
                            b1.setSubmarineHP(b1.getSubmarineHP() - 1);
                            if (b1.getSubmarineHP() == 0) {
                                System.out.println("You sunk " + b1.getP1Name() + "'s Submarine!");
                                b1.setShipsDown(b1.getShipsDown() + 1);
                            }
                        }
                        if(b1.board1.get(b2.getPlace()).equals("P")) {
                            b1.setPatrolBoatHP(b1.getPatrolBoatHP() - 1);
                            if (b1.getPatrolBoatHP() == 0) {
                                System.out.println("You sunk " + b1.getP1Name() + "'s Patrol Boat!");
                                b1.setShipsDown(b1.getShipsDown() + 1);
                            }
                        }
                    }
                    else{
                        System.out.println("You've already fired there.");
                        b2.setPlaced(false);
                    }
                }
                if(b1.getShipsDown() == 5){
                    b1.setP1Lose(true);
                    b1.setP1turn(false);
                    b2.setP2turn(false);
                }
                else {
                    b1.setP1turn(true);
                    b2.setP2turn(false);
                }
            }


        }
        if (b1.getP1Lose()){
            System.out.println("Player 2 wins!");
        }
        else{
            System.out.println("Player 1 wins!");
        }

    }
}