package minefield;

import mvc.Model;
import mvc.View;
import stopLight.Stoplight;

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
        for(int i=0; i<mf.getMineField().length; i++){
            for(int j=0; j<mf.getMineField()[i].length; j++){

                JLabel current = new JLabel();
                current.setHorizontalAlignment(SwingConstants.CENTER);
                current.setOpaque(true);
                current.setBackground(Color.gray);

                if(mf.getMineField()[i][j].discovered){
                    if(mf.getMineField()[i][j].hasMine){
                        current.setBorder(BorderFactory.createLineBorder(Color.pink));
                        current.setBackground(Color.pink);
                        current.setText("M");
                    }
                    else if(!mf.getMineField()[i][j].isExit){
                        current.setBorder(BorderFactory.createLineBorder(Color.white));
                        current.setText(String.valueOf(mf.getMineField()[i][j].nearMines));
                    }
                    else{
                        current.setBorder(BorderFactory.createLineBorder(Color.orange));
                        current.setBackground(Color.orange);
                        current.setText("W");
                    }
                }
                else if(mf.getMineField()[i][j].isExit){
                    current.setBorder(BorderFactory.createLineBorder(Color.green));
                    current.setText("E");
                }
                else{
                    current.setBorder(BorderFactory.createLineBorder(Color.black));
                    current.setText("?");
                }
                add(current);
            }
        }

    }
}
