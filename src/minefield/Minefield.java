package minefield;

import mvc.*;

import javax.swing.*;
import java.util.*;

class Square extends JLabel {
    private boolean hasMine, discovered, isExit; //Whether or not contains mine and whether or not person has stepped on.
    private int nearMines;
    public Square(boolean hasMine, boolean discovered, boolean isExit){
        this.hasMine = hasMine;
        this.discovered = discovered;
        this.isExit = isExit;
    }

    public void setNearbyMines(int nearMines){
        this.nearMines = nearMines;
    }

    public int getNearMines(){
        return nearMines;
    }

    public String toString(){
        return "Has Mine: " + hasMine;
    }

    public boolean hasMine(){
        return hasMine;
    }

    public boolean getDiscovered(){
        return discovered;
    }

}
public class Minefield extends Model { //The minefield is a 20x20 grid

    private Square[][] minefield;
    Random rd = new Random();

    public Minefield(){
        minefield = new Square[20][20];
        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[i].length; j++){
                if(rd.nextBoolean() == true){
                    minefield[i][j] = new Square(true,false, false);
                }
                else{
                    minefield[i][j] = new Square(false,false, false);
                }
            }
        }
        minefield[0][0] = new Square(false,true, false); //starter square
        minefield[19][19] = new Square(false, false, true); //exit square
    }

    public void printAllMines(){
        String txt = "";
        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[i].length; j++){
                txt += minefield[i][j].toString() + " ";
            }
            txt += "\n";
        }
        System.out.println(txt);
    }

    public void findNearMines(int i, int j){
        int nearMines = 0;
        if(i == 0 || i == 19 || j == 0 || j == 19){ //Check Edge squares
            if(i == 0 && j == 0){ //first square
                if(minefield[i+1][j].hasMine()){
                    nearMines++;
                }
            }
            else if(i == 19 && j == 19){ //last square

            }
            else if(i == 0){

            }
            else if(i == 19){ //Bottom row

            }
            else if(j == 0){ //Left column

            }
            else if(j == 19){ //Right colum

            }
        }
        else{ //Check Middle squares
            if(minefield[i+1][j].hasMine()){
                nearMines++;
            }
            else if(minefield[i-1][j].hasMine()){
                nearMines++;
            }
            else if(minefield[i][j+1].hasMine()){
                nearMines++;
            }
            else if(minefield[i][j-1].hasMine()){
                nearMines++;
            }
            else if(minefield[i+1][j+1].hasMine()){
                nearMines++;
            }
            else if(minefield[i+1][j+1].hasMine()){
                nearMines++;
            }
        }

        minefield[i][j].setNearbyMines(nearMines);
    }



    public Square[][] getMineField() {
        return minefield;
    }

    //public String toString() { return "stopLight.color = " + color; }

    public void change() {
        changed(); // from Model, sets changed flag and fires changed event
    }


}