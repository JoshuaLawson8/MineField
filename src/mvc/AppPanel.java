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
    private View view;
    AppFactory af;
    private JFrame frame;
    protected JPanel controlPanel;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;
    public AppPanel(AppFactory factory) {
        controlPanel = new JPanel();

        af = factory;
        model = af.makeModel();
        view = af.makeView(model);

        setLayout((new GridLayout(1, 2)));
        add(controlPanel);
        add(view);

        controlPanel.setBackground(Color.PINK);
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

    public void display() { frame.setVisible(true); }

    public void propertyChange(PropertyChangeEvent pe){}

    public void actionPerformed(ActionEvent ae) {
        String cmmd = ae.getActionCommand();
        /*if (cmmd == "Save") {
            model.setUnsavedChanges(false);
            try {
                //String fName = Utilities.ask("File Name?");
                String fName = Utilities.getFileName(null, false);
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                os.writeObject(model);
                os.close();
            } catch (Exception err) {
                Utilities.error(err);
            }
        } else if (cmmd == "Open") {
            if(model.getUnsavedChanges()) {
                if (!Utilities.confirm("Open without saving?")) {
                    try {
                        String fName = Utilities.getFileName(null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        //model.removePropertyChangeListener(this);
                        model = (Turtle) is.readObject();
                        //this.model.initSupport();
                        //model.addPropertyChangeListener(this);
                        view.setModel(model);
                        is.close();
                    } catch (Exception err) {
                        Utilities.error(err.getMessage());
                    }
                }
            } else{
                try {
                    String fName = Utilities.getFileName(null, true);
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                    //model.removePropertyChangeListener(this);
                    model = (Turtle)is.readObject();
                    //this.model.initSupport();
                    //model.addPropertyChangeListener(this);
                    view.setModel(model);
                    is.close();
                } catch (Exception err) {
                    Utilities.error(err.getMessage());
                }
            }
        } else if (cmmd == "New") {
            model = new Turtle();
            view.setModel(model);
        } else if (cmmd == "Quit") {
            //Utilities.saveChanges(model);
            if(view.getUnsavedChanges()){
                if(!Utilities.confirm("Exit without saving?")){
                    System.exit(1);
                }
            }
            else{
                System.exit(1);
            }

        } else if (cmmd == "About") {
            Utilities.inform(view.getAbout());
        } else if (cmmd == "Help") {
            Utilities.inform("Click the buttons to move the turtle. \nPen toggles whether or not to draw. \nClear removes the lines\nTo Select a color use the color button");
        }  else  {
            Utilities.error("Unrecognized command: " + cmmd);
        }
        *
         */
    }

}
