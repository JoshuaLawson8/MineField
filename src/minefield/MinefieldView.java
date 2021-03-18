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
        Color oldColor = gc.getColor();

        Minefield mf = (Minefield) model;
        int size = 12;
        gc.setColor(Color.gray);

        for(int i = 0; i < 240; i+=12)
            for(int j = 0; j < 240; j+=12)
                gc.drawRect(i,j,size,size);


        gc.setColor(oldColor);

    }
}
