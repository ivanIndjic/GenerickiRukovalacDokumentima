package segments;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import actions.ActionManager;
import actions.OpenAction;
import actions.RedoAction;
import actions.UndoAction;
import app.MyApp;

public class MyMenuBar extends JMenuBar {
	
	private JMenu file; 
	private JMenu edit;
	private JMenu help;
	private JMenu tools;
	
	public MyMenuBar() {
		
		file = new JMenu(MyApp.getInstance().getResourceBundle().getString("file"));
		file.add(ActionManager.getInstance().getSaveAction());
		file.add(new OpenAction());
		file.add(ActionManager.getInstance().getRemoveAction());
		file.add(ActionManager.getInstance().getChangeAction());
		
		
		edit = new JMenu(MyApp.getInstance().getResourceBundle().getString("edit"));
		edit.add(ActionManager.getInstance().getUndoAction());
		edit.add(ActionManager.getInstance().getRedoAction());
		
		tools = new JMenu(MyApp.getInstance().getResourceBundle().getString("tools"));
		tools.add(ActionManager.getInstance().getProjectAction());
		tools.add(ActionManager.getInstance().getDocumentAction());
		tools.add(ActionManager.getInstance().getPageAction());
		tools.add(ActionManager.getInstance().getMoreSlotsAction());
		tools.add(ActionManager.getInstance().getElementAction());
		
		
		tools.add(ActionManager.getInstance().getIndependentAction());
		tools.add(ActionManager.getInstance().getLast());
		tools.add(ActionManager.getInstance().getMostUsed());
		
		help = new JMenu(MyApp.getInstance().getResourceBundle().getString("help"));
		
		this.add(file);
		this.add(edit);
		this.add(tools);
	
		this.add(help);
		
		

	}
 
}
