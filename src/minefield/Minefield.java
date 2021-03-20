package minefield;

import mvc.*;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.beans.VetoableChangeListener;

public class Minefield extends Model { //The minefield is a 20x20 grid

    private Square[][] minefield;
    private int userX;
    private int userY;

    public Minefield(int Mines){
        minefield = new Square[20][20];
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
        minefield[0][0].setText(String.valueOf(minefield[0][0].nearMines));
        minefield[0][0].setBorder(BorderFactory.createLineBorder(Color.white));
        minefield[19][19].isExit = true;
        minefield[19][19].setBorder(BorderFactory.createLineBorder(Color.green));
        userX = 0;
        userY = 0;
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


    public Square[][] getMineField() { return minefield; }

    public void checkGameStatus(){
        //System.out.println("checking status");
        try {
            if (minefield[userX][userY].hasMine) { //Steps on mine lose game
                System.out.println("Game over!");
                if (!Utilities.confirm("You lost! New Game?")) {
                    System.out.println("Create new game");
                }
            } else if (minefield[userX][userY].isExit) { //Gets to exit
                if (!Utilities.confirm("You Win! New Game?")) {
                    System.out.println("Create new game");
                }
            }
        }catch (ArrayIndexOutOfBoundsException e ){
            Utilities.inform("You went out of Bounds, Try again, from Start");
            userY=0;userX=0;
        }
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

    public Square getUser(){
        return minefield[userX][userY];
    }

    public void printAllMines(){
        for(int i=0; i<minefield.length; i++){
            for(int j=0; j<minefield[i].length; j++){
                System.out.print(minefield[i][j].hasMine ? "x " : "o ");
            }
            System.out.println();
        }
    }

    public void change(String heading) {

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
        checkGameStatus();
        /*minefield[userX][userY].discovered = true;
        minefield[userX][userY].setBorder(BorderFactory.createLineBorder(Color.white));
        minefield[userX][userY].setText(String.valueOf(minefield[userX][userY].nearMines));*/
        changed(); // from Model, sets changed flag and fires changed event
    }

    class Square extends JLabel {

        boolean hasMine, discovered, isExit;
        int nearMines;

        Square(boolean hasMine, boolean discovered, boolean isExit){
            this.hasMine = hasMine;
            this.discovered = discovered;
            this.isExit = isExit;
            this.nearMines = -1;
            setText("?");
            setHorizontalAlignment(SwingConstants.CENTER);
            setBorder(BorderFactory.createLineBorder(Color.black));
            setOpaque(true);
            setBackground(Color.gray);
        }

//        public String toString(){
//            return "Has Mine: " + hasMine;
//        }

    }

}