package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import app.MyApp;
import commandMenager.MyUpdateCommand;
import model.AbstractCollection;
import model.Dokument;
import model.Page;
import model.Slot;
import stablo.MyTreeModel;

public class ChangeActionListener implements ActionListener {
	
	private JTextArea setname;
    private JFrame frame;
    private AbstractCollection object;
    
	public  ChangeActionListener(JTextArea jta, JFrame jfr, AbstractCollection o){

		this.setname=jta;
		this.frame=jfr;
		this.object = o;
	
     }
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String ime = setname.getText();
		
		if(ime.equals("")){
			JOptionPane.showMessageDialog(frame, MyApp.getInstance().getResourceBundle().getString("mustName"));
			
		}
		else{
			if(object instanceof Dokument) {
				if(!(((Dokument) object).isKopija())){
					Dokument dok = (Dokument) object;
					dok.getKomandMenadzer().dodajKomandu(new MyUpdateCommand(dok));  //ovo
				}
				
			} else if(object instanceof Page) {
				if(!(((Page) object).isKopija())){
				    Page page = (Page) object;
				    page.getParent().getKomandMenadzer().dodajKomandu(new MyUpdateCommand(page)); //ovo
				}
			} else if(object instanceof Slot) {
				
				Slot slot = (Slot) object;
				slot.getParent().getParent().getKomandMenadzer().dodajKomandu(new MyUpdateCommand(slot));//ovo 
			} 
			object.setName(ime);
			MyTreeModel m = (MyTreeModel) MyApp.getInstance().getTree().getModel();
			m.update(object, this);
			frame.setVisible(false);   
			
		}
		

		
	}

}
