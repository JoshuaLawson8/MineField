package minefield;

import mvc.*;

public class MinefieldFactory implements AppFactory {

    public Model makeModel() { return new Minefield(10); }

    public View makeView(Model m) { return new MinefieldView((Minefield)m); }

    public String[] getEditCommands() { return new String[]{"NW","N","NE","W","E","SW","S","SE"}; }

    public Command makeEditCommand(Model model, String type) {
        for( String s : getEditCommands()){
            if (type == s){ return new MineCommand(model,s); }
        }
        return null;
    }

    public String getTitle() { return "Minefield on mvc"; }

    public String[] getHelp() {
        return new String[] {"Click the buttons to move you in one of eight directions on the minefield"};
    }

    public String about() {
        return "Minefield on mvc version 1.0. Copyright Pending 2021, by JJE Productions ";
    }
}
