package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;

public class ExitAppAction extends AbstractAction {
	
	public ExitAppAction() {
		Icon icon = new ImageIcon(new ImageIcon("resources/exit.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("exit"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("exit"));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Serialization.SaveSlobodneElemente();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.exit(0);
		
	}

}
