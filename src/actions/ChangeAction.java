package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.ChangeDialog;

public class ChangeAction extends AbstractAction{
	
	public ChangeAction() {
		Icon icon = new ImageIcon(new ImageIcon("resources/update.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Change"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Change"));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ChangeDialog c=new ChangeDialog();
	}

}
