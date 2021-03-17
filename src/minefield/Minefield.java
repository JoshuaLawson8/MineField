package minefield;

import mvc.*;

import java.awt.Color;
import java.util.*;

public class Minefield extends Model { //The minefield is a 20x20 grid

    class Square {
        private boolean hasMine, discoved; //Whether or not contains mine and whether or not person has stepped on.

        public Square(boolean hasMine, boolean discoved){
            this.hasMine = hasMine;
            this.discoved = discoved;
        }

        public void getNearbyMines(){}

        public boolean getDiscovered(){
            return discoved;
        }

    }

    private Square[][] minefield = new Square[20][20];



    public Square[][] getMineField() {
        return minefield;
    }

    //public String toString() { return "stopLight.color = " + color; }

    public void change() {
        changed(); // from Model, sets changed flag and fires changed event
    }
}