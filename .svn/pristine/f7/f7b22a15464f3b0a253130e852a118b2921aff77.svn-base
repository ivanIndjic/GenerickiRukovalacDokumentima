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
import view.MoreSlotsWindoww;

public class NewMoreSlotsAction extends AbstractAction{

    public NewMoreSlotsAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/images.jpg").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_M);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newSlots"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("addSlots"));
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	   MoreSlotsWindoww msw = new MoreSlotsWindoww();
	}
}
