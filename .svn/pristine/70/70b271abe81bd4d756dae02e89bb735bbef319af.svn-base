package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import view.IndependentDialog;

public class IndependentDocumentsAction extends AbstractAction {

    public IndependentDocumentsAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/independent.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(SMALL_ICON, icon);
		putValue(NAME,  MyApp.getInstance().getResourceBundle().getString("freeDocs"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("freeDocs"));
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		IndependentDialog i = new IndependentDialog(MyApp.getInstance(),"Slobodni dokumenti",true);
		i.setVisible(true);
		
	}

}
