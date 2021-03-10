package mvc;
/* Edit history
   class made my Jesse 3/10
 */
public interface AppFactory {
    public Model makeModel();
    public View makeView(Model m);
    public String getTitle();
    public String[] getHelp();
    public String about();
    public String[] getEditCommands();
    public Command makeEditCommand(Model m,String name);

}
