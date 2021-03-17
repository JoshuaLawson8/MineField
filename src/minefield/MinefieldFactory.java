package minefield;

import mvc.*;

public class MinefieldFactory implements AppFactory {
    public Model makeModel() { return null; }

    public View makeView(Model m) { return null; }

    public String[] getEditCommands() { return null; }

    public Command makeEditCommand(Model model, String type) {
        //if (type == "Change")
        //    return new ChangeCommand(model);
        return null;
    }

    public String getTitle() { return ""; }

    public String[] getHelp() {
        return new String[] {""};
    }

    public String about() {
        return "";
    }
}
