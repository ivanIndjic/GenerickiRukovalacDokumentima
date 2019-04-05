package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.MostUsedDialog;

public class MostUsedDocuments extends AbstractAction{

public MostUsedDocuments() {	
		Icon icon = new ImageIcon(new ImageIcon("resources/mud.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_U);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("mostDocs"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("mostDocs"));
			
	}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
MostUsedDialog msd = new MostUsedDialog();
}
}
