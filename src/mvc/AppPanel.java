package mvc;

import tools.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
//aaaa
public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    private Model model;
    AppFactory af;
    private View view;
    private JFrame frame;
    public JPanel controlPanel;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;
    public AppPanel(AppFactory factory) {
        controlPanel = new JPanel();
        model = new Model();
        af = factory;
        JPanel controlPanel = new JPanel();
        view = new View(model);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[] {"New",  "Save", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu =
                Utilities.makeMenu("Edit", af.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    public void display() { frame.setVisible(true); }

    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
