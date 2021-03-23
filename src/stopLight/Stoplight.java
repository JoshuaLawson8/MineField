package stopLight;

import mvc.*;
import java.awt.Color;

public class Stoplight extends Model {
    private Color color = Color.GREEN;

    public Color getColor() {
        return color;
    }

    public String toString() { return "stopLight.color = " + color; }

    public void change() {
        if (color.equals(Color.GREEN)) color = Color.YELLOW;
        else if (color.equals(Color.YELLOW)) color = Color.RED;
        else if (color.equals(Color.RED)) color = Color.GREEN;
        changed(); // from Model, sets changed flag and fires changed event
    }
}