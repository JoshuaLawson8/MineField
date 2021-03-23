package minefield;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

public class MinefieldPanel extends AppPanel{

        public MinefieldPanel(AppFactory factory) {
            super(factory);
            String[] buttonNames = {"NW","N","NE","W","","E","SW","S","SE"};
            for(int i = 0; i < buttonNames.length; i++) {
                JButton current = new JButton(buttonNames[i]);
                current.setPreferredSize(new Dimension(75, 50));
                current.addActionListener(this);
                controlPanel.add(current);
            }
            controlPanel.setLayout(new FlowLayout());
            //view.changed()
        }

        public static void main(String[] args) {
            AppFactory factory = new MinefieldFactory();
            AppPanel panel = new MinefieldPanel(factory);
            panel.display();
        }
}
