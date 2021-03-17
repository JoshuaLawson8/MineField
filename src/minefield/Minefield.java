package minefield;

import mvc.*;

import java.awt.Color;
import java.util.*;

class Square {
    private boolean hasMine, discoved; //Whether or not contains mine and whether or not person has stepped on.
    private int mines;
    public Square(boolean hasMine, boolean discoved, int mines){
        this.hasMine = hasMine;
        this.discoved = discoved;
        this.mines = mines;
    }

    public void getNearbyMines(){}

    public boolean getDiscovered(){
        return discoved;
    }

}
public class Minefield extends Model { //The minefield is a 20x20 grid

    private Square[][] minefield;
    Random rd = new Random();

    public Minefield(){
        minefield = new Square[20][20];
        minefield[0][0] = new Square(false,true, 0); //starter square
        for(int i=1; i<minefield.length; i++){
            for(int j=1; j<minefield[i].length; j++){
                if(rd.nextBoolean() == true){
                    minefield[i][j] = new Square(true,false, 1);
                }
                else{
                    minefield[i][j] = new Square(false,false, 0);
                }
            }
        }

    }

    public Square[][] getMineField() {
        return minefield;
    }

    //public String toString() { return "stopLight.color = " + color; }

    public void change() {
        changed(); // from Model, sets changed flag and fires changed event
    }
}