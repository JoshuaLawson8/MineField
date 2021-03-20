package minefield;

import mvc.View;
import stopLight.Stoplight;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends View {

    private Minefield mf;

    public MinefieldView(Minefield minefield){
        super(minefield);
        setLayout(new GridLayout(20,20));
        mf = (Minefield) model;
        for(int i=0; i<mf.getMineField().length; i++){
            for(int j=0; j<mf.getMineField()[i].length; j++){
                add(mf.getMineField()[i][j]);
            }
        }
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt){
        /*int label = mf.getUser().nearMines;
        JLabel patch = new JLabel(String.valueOf(label));
        patch.setBorder(BorderFactory.createLineBorder(Color.white));
        add(patch);
        System.out.println("pchanged");*/
        //repaint();

    }
}
