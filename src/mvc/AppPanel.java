package mvc;

import minefield.Minefield;
import tools.Utilities;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import javax.swing.*;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    protected Model model;
    protected View view;
    protected JPanel controlPanel;
    protected AppFactory af;

    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;

    public AppPanel(AppFactory factory) {
        af = factory;
        model = af.makeModel();
        addPropertyChangeListener(this);
        controlPanel = new JPanel();
        view = af.makeView(model);

        setLayout((new GridLayout(1, 2)));
        add(controlPanel);
        add(view);

        view.setBackground(Color.WHITE);

        frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(af.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
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

    public void display() {
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){

    }

    public void actionPerformed(ActionEvent ae) {
        try{
            String cmmd = ae.getActionCommand();

            if (cmmd == "Save") {
                model.setUnsavedChanges(false);
                //String fName = Utilities.ask("File Name?");
                String fName = Utilities.getFileName(null, false);
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                os.writeObject(model);
                os.close();
            } else if (cmmd == "Open") {
                Boolean unsaved = true;
                if (model.getUnsavedChanges()) {
                    unsaved = !Utilities.confirm("Open without saving?");
                }
                if(unsaved){
                    String fName = Utilities.getFileName(null, true);
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                    //model.removePropertyChangeListener(this);
                    model = (Model) is.readObject();
                    //this.model.initSupport();
                    //model.addPropertyChangeListener(this);
                    view.setModel(model);
                    model.changed();
                    is.close();
                }
            } else if (cmmd == "New") {
                model = af.makeModel();
                view.setModel(model);
                model.changed();
            } else if (cmmd == "Quit") {
                //Utilities.saveChanges(model);
                if (model.getUnsavedChanges()) {
                    if (!Utilities.confirm("Exit without saving?")) {
                        System.exit(1);
                    }
                } else {
                    System.exit(1);
                }
            } else if (cmmd == "About") {
                Utilities.inform(af.about());
            } else if (cmmd == "Help") {
                Utilities.inform(af.getHelp());
            } else {
                for(String s : af.getEditCommands()){
                    if(cmmd == s){
                        af.makeEditCommand(model,cmmd,null).execute();
                    }
                }
            }
        }catch (Exception e) {
            handleException(e);
        }
        revalidate();
        repaint();
    }

    protected void handleException(Exception e){
        Utilities.error(e);
    }
}
