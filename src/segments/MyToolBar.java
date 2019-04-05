package segments;

import javax.swing.JToolBar;

import actions.ActionManager;
import actions.ExitAppAction;
import actions.OpenAction;
import actions.RedoAction;
import actions.UndoAction;

public class MyToolBar extends JToolBar {
	
	public MyToolBar() {
		
		super(JToolBar.HORIZONTAL);
		setFloatable(false);
		
		add(ActionManager.getInstance().getSaveAction());
		add(new OpenAction());
		add(ActionManager.getInstance().getRemoveAction());
		add(ActionManager.getInstance().getChangeAction());
		add(ActionManager.getInstance().getCloseAction());///////////
		add(ActionManager.getInstance().getShareAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getProjectAction());
		add(ActionManager.getInstance().getDocumentAction());
		add(ActionManager.getInstance().getPageAction());
		add(ActionManager.getInstance().getMoreSlotsAction());
		add(ActionManager.getInstance().getElementAction());
				
		
		addSeparator();
		
		
		add(ActionManager.getInstance().getUndoAction());
		add(ActionManager.getInstance().getRedoAction());
		add(new ExitAppAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getIndependentAction());
		add(ActionManager.getInstance().getMostUsed());
		add(ActionManager.getInstance().getLast());
		
		
	}

	
}
