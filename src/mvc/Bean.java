package mvc;

import java.beans.*;
import java.io.*;

abstract public class Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * mPcs and mVcs contain lists of event listeners
     * (views and panels mostly). We don't want these
     * saved to a file along with the model (which
     * inherits them). Therefore we declare them to
     * be transient.
     */
    transient protected PropertyChangeSupport mPcs =
            new PropertyChangeSupport(this);

    transient protected VetoableChangeSupport mVcs =
            new VetoableChangeSupport(this);

    /*
     * When a saved model is read back in from a file we
     * must provide them with new supports since the old ones
     * weren't saved:
     */
    public void initSupport() {
        if (mPcs == null) mPcs = new PropertyChangeSupport(this);
        if (mVcs == null) mVcs = new VetoableChangeSupport(this);
    }

    public void fireVetoableChange(String propertyName, Object oldValue, Object newValue) throws PropertyVetoException {
        mVcs.fireVetoableChange(propertyName, oldValue, newValue);
    }

    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        mPcs.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        mPcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        mPcs.removePropertyChangeListener(listener);
    }

    public void addVetoableChangeListener(VetoableChangeListener listener) {
        mVcs.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        mVcs.removeVetoableChangeListener(listener);
    }

}


