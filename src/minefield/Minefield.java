package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Minefield extends Model { //The minefield is a 20x20 grid

    private Square[][] minefield;
    Random rd = new Random();
    private Square user;
    public Square getUser(){return user;}

    public Minefield(int Mines){
        minefield = new Square[20][20];
        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[i].length; j++){
                minefield[i][j] = new Square(false,false, false);
            }
        }
        //Generates random x and y coords to put in Mines based on amount of specified mines (in constructor)
        for(int i = 0; i < Mines; i++){
            int x = (int)(Math.random() * 20 );
            int y = (int)(Math.random() * 20 );
            if(minefield[x][y].hasMine || (x == 0 && y == 0) || (x == 19 && y == 19)){ i--;}
            else{minefield[x][y].hasMine = true;}
        }
        //setting entrance and exit
        minefield[0][0].discovered = true;
        minefield[19][19].isExit = true;
        user = minefield[0][0];
    }

    public void printAllMines(){
        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[i].length; j++){
                System.out.print(minefield[i][j].hasMine ? "x " : "o ");
            }
            System.out.println();
        }
    }

    public void findNearMines(int xPos, int yPos){
        int nearMines = 0;
        for(int i = xPos-1; i < xPos+2; i++) {
            for (int j = yPos - 1; j < yPos + 2; j++) {
                if (!(i == -1 || j == -1 || i == 20 || j == 20 || (i == xPos && j == yPos)))//check all boarders
                    nearMines += minefield[i][j].hasMine ? 1 : 0;
            }
        }
        System.out.print(nearMines);
    }

    public void showRevealedMines(){
        for(int i =0; i < 20; i++){
            for(int j =0; j < 20; j++){
                findNearMines(i,j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //do we ever need minefield outside?
    public Square[][] getMineField() {
        return minefield;
    }
    public Minefield getField(){
        return this;
    }

    //public String toString() { return "stopLight.color = " + color; }

    public void change(String heading) {

        if(heading == "N"){ user = minefield[user.getX()][user.getY()-1];}
        else if(heading == "E"){ user = minefield[user.getX()+1][user.getY()];}
        else if(heading == "S"){ user = minefield[user.getX()][user.getY()+1];}
        else if(heading == "W"){ user = minefield[user.getX()-1][user.getY()];}
        else if(heading == "NE"){ user = minefield[user.getX()+1][user.getY()-1];}
        else if(heading == "NW"){ user = minefield[user.getX()-1][user.getY()-1];}
        else if(heading == "SE"){ user = minefield[user.getX()+1][user.getY()+1];}
        else if(heading == "SW"){ user = minefield[user.getX()-1][user.getY()+1];}
        changed(); // from Model, sets changed flag and fires changed event
    }

    class Square extends JLabel {
        boolean hasMine, discovered, isExit; //Whether or not contains mine and whether or not person has stepped on.
        int nearMines;
        Square(boolean hasMine, boolean discovered, boolean isExit){
            this.hasMine = hasMine;
            this.discovered = discovered;
            this.isExit = isExit;
            this.nearMines = -1;
            setText("?");
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        public boolean hasMine(){
            return hasMine;
        }
        //Is needed?
        public String toString(){
            return "Has Mine: " + hasMine;
        }

        public void setValue(String text){setText(text);}
    }
}