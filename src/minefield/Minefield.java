package minefield;

import mvc.*;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.beans.VetoableChangeListener;

public class Minefield extends Model{ //The minefield is a 20x20 grid

    private Square[][] minefield;
    private int userX,userY;
    public Minefield(int Mines){

        minefield = new Square[20][20];
        userX = 0;
        userY = 0;

        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[0].length; j++){
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
        for(int i =0; i < minefield.length; i++){
            for(int j =0; j < minefield[0].length; j++){
                findNearMines(i,j);
            }
        }
        //setting entrance and exit
        minefield[0][0].discovered = true;
        minefield[19][19].isExit = true;
    }

    public void findNearMines(int xPos, int yPos){
        int localMines = 0;
        for(int i = xPos-1; i < xPos+2; i++) {
            for (int j = yPos - 1; j < yPos + 2; j++) {
                if (!(i == -1 || j == -1 || i == 20 || j == 20 || (i == xPos && j == yPos)))//check all boarders
                    localMines += minefield[i][j].hasMine ? 1 : 0;
            }
        }
        minefield[xPos][yPos].nearMines = localMines;
    }

    public void changeState(String heading) {
        switch (heading) {
            case "S": userX++;break;
            case "W": userY--;break;
            case "E": userY++;break;
            case "N": userX--;break;
            case "NW": userY--;userX--;break;
            case "NE": userY++;userX--;break;
            case "SW": userY--;userX++;break;
            case "SE": userY++;userX++;break;
        }
        try{
            minefield[userX][userY].discovered = true;
        }catch(Exception e){
            switch (heading) {
                case "S": userX--;break;
                case "W": userY++;break;
                case "E": userY--;break;
                case "N": userX++;break;
                case "NW": userY++;userX++;break;
                case "NE": userY--;userX++;break;
                case "SW": userY++;userX--;break;
                case "SE": userY--;userX--;break;
            }
            Utilities.error("Out of bounds");
        }
        changed(); // from Model, sets changed flag and fires changed event
        if(minefield[userX][userY].hasMine){
            Utilities.error("Stepped on mine");
        }
    }

    public Square[][] getMinefield(){return minefield;}
    public int userX(){return userX;}
    public int userY(){return userY;}

    class Square {

        boolean hasMine, discovered, isExit;
        int nearMines;

        Square(boolean hasMine, boolean discovered, boolean isExit){
            this.hasMine = hasMine;
            this.discovered = discovered;
            this.isExit = isExit;
            this.nearMines = -1;
        }
    }
}