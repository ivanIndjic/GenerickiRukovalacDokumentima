package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import model.Dokument;

public class RedoAction extends AbstractAction {
	public RedoAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/redo.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("redo"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("redo"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
		
		if(o instanceof Dokument){
			 Dokument dokument = (Dokument) o;
			 if(dokument.getKomandMenadzer().getRedoLista().size() == 0) {
				 ActionManager.getInstance().getRedoAction().setEnabled(false);
			 } else {
			     dokument.getKomandMenadzer().redo();
			 }
		}
		
	}
}
