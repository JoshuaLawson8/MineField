package minefield;

import mvc.View;
import stopLight.Stoplight;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends View {
    Minefield mf;

    public MinefieldView(Minefield minefield){
        super(minefield);
        setLayout(new GridLayout(20,20));
        mf = (Minefield) model;
        for(int i=0; i<mf.getMineField().length; i++){
            for(int j=0; j<mf.getMineField()[i].length; j++){
                if(mf.getMineField()[i][j].hasMine() == true){
                    JLabel patch = new JLabel("x");
                    patch.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(patch);
                }
                else{
                    JLabel patch = new JLabel("o");
                    patch.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(patch);
                }
            }
        }
    }
    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        //System.out.println("Drawing");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        mf = mf.getField();//made get Minefield object method
        int label = mf.getUser().nearMines;
        JLabel patch = new JLabel(String.valueOf(label));
        patch.setBorder(BorderFactory.createLineBorder(Color.white));
        add(patch);
        System.out.println("pchanged");
    }
}
