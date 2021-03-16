package stopLight;

import javax.swing.*;

import mvc.AppPanel;

import mvc.*;


public class StoplightPanel extends AppPanel {
    private JButton change;
    public StoplightPanel(AppFactory factory) {
        super(factory);

        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);

    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }

}

