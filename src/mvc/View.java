package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class View extends JPanel implements PropertyChangeListener {


    private Model model;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
