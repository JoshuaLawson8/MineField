package stopLight;

import mvc.*;
import java.awt.*;

public class StoplightView extends View {

    public StoplightView(Stoplight light) {
        super(light);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Stoplight light = (Stoplight)model;
        Color oldColor = gc.getColor();
        gc.setColor(light.getColor());
        gc.fillOval(100, 100, 20, 20);
        gc.setColor(oldColor);
    }
}