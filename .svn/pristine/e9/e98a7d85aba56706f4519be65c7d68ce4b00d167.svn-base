package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import app.MyApp;
import model.Element;

public class AddingElement extends AbstractAction{
	 	private JTextArea setname;
	    private JFrame document;
	    public AddingElement(JTextArea jta, JFrame jfr){
			this.setname=jta;
			this.document=jfr;
		
	    }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ime = setname.getText();
			
			if(ime.equals("")){
				JOptionPane.showMessageDialog(document, MyApp.getInstance().getResourceBundle().getString("mustName"));
				
			}
			else{
				Element el = new model.Element(ime);
				el.addObserver(MyApp.getInstance().getModelTree());
				el.setParent(MyApp.getInstance().getSlot());//vraca aktivni slot
				MyApp.getInstance().getSlot().AddElement(el);   
				
			   document.setVisible(false);
			}
			
		}
}
