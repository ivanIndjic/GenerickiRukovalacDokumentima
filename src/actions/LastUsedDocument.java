package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.LastUsedDocumentsDialog;

public class LastUsedDocument extends AbstractAction{
     public LastUsedDocument() {

	Icon icon = new ImageIcon(new ImageIcon("resources/lud.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("lastDocs"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("lastDocs"));
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	LastUsedDocumentsDialog ludd = new LastUsedDocumentsDialog();	
	}
}
