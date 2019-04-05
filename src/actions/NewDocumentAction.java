package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.DocumentWindow;

public class NewDocumentAction extends AbstractAction {

    public NewDocumentAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/ikonica.jpg").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newDoc"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("addDoc"));
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	   DocumentWindow dw = new DocumentWindow();
	}

}
