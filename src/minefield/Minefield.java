package minefield;

import mvc.*;

import javax.swing.*;
import java.util.*;

public class Minefield extends Model { //The minefield is a 20x20 grid

    private Square[][] minefield;
    //Random rd = new Random();

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
            if(minefield[x][y].hasMine || (x == 0 && y ==0) || (x == 19 && y == 19)){ i--;}
            else{minefield[x][y].hasMine = true;}
        }
        //setting entrance and exit
        minefield[0][0].discovered = true;
        minefield[19][19].isExit = true;
    }

    public void printAllMines(){
        String txt = "";
        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[i].length; j++){
                System.out.print(minefield[i][j].hasMine ? "x " : "o ");
            }
            System.out.println("\n");
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

    //do we ever need minefield?
    public Square[][] getMineField() {
        return minefield;
    }

    //public String toString() { return "stopLight.color = " + color; }

    public void change() {
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
        }
        //Is needed?
        public String toString(){
            return "Has Mine: " + hasMine;
        }
    }
}