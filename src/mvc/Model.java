package mvc;

import tools.Bean;

public abstract class Model extends Bean{

    private boolean unsavedChanges = false;
    private String fileName = null;

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }
    public void setFileName(String fName) {
        fileName = fName;
    }

    public void changed(){
        boolean oldStatus = unsavedChanges;
        unsavedChanges = true;
        firePropertyChange(null, null, null);
        System.out.println("changed");
    }
}
