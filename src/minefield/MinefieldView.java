package minefield;

import mvc.View;
import stopLight.Stoplight;

import java.awt.*;

public class MinefieldView extends View {

    public MinefieldView(Minefield minefield){
        super(minefield);
    }
    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Minefield mf = (Minefield) model;
        Color oldColor = gc.getColor();

        //System.out.println("Drawing");
    }
}
