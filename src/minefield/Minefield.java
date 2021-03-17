package minefield;

import mvc.*;

import java.awt.Color;
import java.util.*;

public class Minefield extends Model { //The minefield is a 20x20 grid

    private char[][] minefield = new char[20][20]; //Each value inside the array is either ? or a number(nearby mines)

    public char[][] getMineField() {
        return minefield;
    }

    //public String toString() { return "stopLight.color = " + color; }

    public void change() {
        changed(); // from Model, sets changed flag and fires changed event
    }
}