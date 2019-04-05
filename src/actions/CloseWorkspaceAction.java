package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import model.Workspace;
import stablo.MyTreeModel;
import view.ChooseWorkspaceDialog;

public class CloseWorkspaceAction extends AbstractAction {

	public CloseWorkspaceAction() {

		Icon icon = new ImageIcon(new ImageIcon("resources/close.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("changeWorkspace"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("changeWorkspace"));
		

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ChooseWorkspaceDialog cwd = new ChooseWorkspaceDialog(MyApp.getInstance(), true);
		cwd.setVisible(true);
		
		Workspace w = cwd.selektovani;
		MyApp.getInstance().setAktivniWorkspace(w);
	    
		MyTreeModel model = (MyTreeModel) MyApp.getInstance().getTree().getModel();
		model.update(w, this);
	}

}
