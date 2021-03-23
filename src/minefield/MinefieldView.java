package minefield;

import mvc.View;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;


public class MinefieldView extends View {


    public MinefieldView(Minefield minefield){
        super(minefield);
        propertyChange(null);//This needs to be fixed
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        removeAll();
        setLayout(new GridLayout(20,20));
        Minefield mf = (Minefield) model;
        for(int i=0; i<mf.getMinefield().length; i++){
            for(int j=0; j<mf.getMinefield()[i].length; j++){

                JLabel current = new JLabel();
                current.setHorizontalAlignment(SwingConstants.CENTER);
                current.setOpaque(true);
                current.setBackground(Color.gray);
                current.setBorder(BorderFactory.createLineBorder(Color.black));
                current.setText("?");

                Minefield.Square currentSquare = mf.getMinefield()[i][j];
                if(currentSquare.discovered){
                    current.setBorder(BorderFactory.createLineBorder(Color.white));
                    current.setText(String.valueOf(mf.getMinefield()[i][j].nearMines));
                    if(currentSquare.hasMine){
                        current.setBorder(BorderFactory.createLineBorder(Color.pink));
                        current.setBackground(Color.pink);
                        current.setText("M");
                    }
                }
                if(currentSquare.isExit){
                    current.setBorder(BorderFactory.createLineBorder(Color.green));
                    current.setText("E");
                }
                if(currentSquare == mf.getMinefield()[mf.userX()][mf.userY()]){
                    current.setBorder(BorderFactory.createLineBorder(Color.cyan));
                    if(currentSquare.isExit){
                        current.setBorder(BorderFactory.createLineBorder(Color.orange));
                        current.setBackground(Color.orange);
                        current.setText("W");
                    }
                }
                add(current);
            }
        }
    }
}
