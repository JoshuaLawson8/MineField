package minefield;

import mvc.Model;
import mvc.Command;

public class MineCommand extends Command{
    private String heading;

    public MineCommand(Model model, String s){super(model);heading = s;}

    public void execute(){
        Minefield field = (Minefield)model;
        field.change(heading);
    }
}

