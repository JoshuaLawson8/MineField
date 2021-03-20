package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class View extends JPanel implements PropertyChangeListener {


    protected Model model;
    public View(Model model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }
    public void setModel(Model model){
        this.model.removePropertyChangeListener(this);
        this.model = model;
        this.model.initSupport();
        this.model.addPropertyChangeListener(this);
        //repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}