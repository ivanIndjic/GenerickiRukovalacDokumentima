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

public class UndoAction extends AbstractAction{
	public UndoAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/undo.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_Y);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("undo"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("undo"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
		
		if(o instanceof Dokument){
			 Dokument dokument = (Dokument) o;
			 if(dokument.getKomandMenadzer().getIzvrseneKomande().size() == 0) {
				 ActionManager.getInstance().getUndoAction().setEnabled(false);
			 } else {
			     dokument.getKomandMenadzer().undo();
			 }
		}
	}
}
