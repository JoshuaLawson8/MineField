package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class View extends JPanel implements PropertyChangeListener {


    protected Model model;
    public View(Model model){
        this.model = model;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}