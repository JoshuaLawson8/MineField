package stopLight;

import mvc.*;

public class StoplightFactory implements AppFactory {

    public Model makeModel() { return new Stoplight(); }

    public View makeView(Model m) {
        return new StoplightView((Stoplight)m);
    }

    public String[] getEditCommands() { return new String[] {"Change"}; }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Change")
            return new ChangeCommand(model);
        return null;
    }

    public String getTitle() { return "Stop Light Simulator"; }

    public String[] getHelp() {
        return new String[] {"click Change to cycle through colors"};
    }

    public String about() {
        return "Stoplight Simulator version 1.0. Copyright 2020 by Cyberdellic Designs";
    }

}