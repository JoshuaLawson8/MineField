package mvc;

import javax.swing.JPanel;
import java.awt.event.*;
import java.beans.*;



public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    private View view;
    private Model model;
    private AppFactory af;

    public static void main(String[] args){
        System.out.println("It's working!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
