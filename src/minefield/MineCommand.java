package minefield;

import mvc.Model;
import mvc.Command;

public class MineCommand extends Command{

    public MineCommand(Model model, String s){super(model);}
    // String s to differentiate between directions? so we dont have to make 8 movecommand classes
    public void execute(){
        Minefield field = (Minefield)model;
        field.change();
    }
}

