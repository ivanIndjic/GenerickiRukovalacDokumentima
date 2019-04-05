package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.lang.model.element.Element;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.DocumentWindow;
import view.ElementWindow;

public class NewElementAction extends AbstractAction{
	 public NewElementAction() {
			
			Icon icon = new ImageIcon(new ImageIcon("resources/txt.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
			
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
			putValue(MNEMONIC_KEY, KeyEvent.VK_T);
			putValue(SMALL_ICON, icon);
			putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newElement"));
			putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("addElement"));
				
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		  ElementWindow ew = new ElementWindow();
		}
}
