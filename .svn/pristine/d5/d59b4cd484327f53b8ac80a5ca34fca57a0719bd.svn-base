package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.ProjectWindow;

public class NewProjectAction extends AbstractAction {
	
	
	public NewProjectAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/project.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newProject"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("addProject"));
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ProjectWindow pw = new ProjectWindow();
		
	}


}
