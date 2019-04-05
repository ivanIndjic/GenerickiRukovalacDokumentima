package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import app.MyApp;
import model.Dokument;

public class AddingDocument implements ActionListener{
    private JTextArea setname;
    private JFrame document;
    
	public  AddingDocument(JTextArea jta, JFrame jfr){

		this.setname=jta;
		this.document=jfr;
	
     }
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	
		String ime = setname.getText();
		
		if(ime.equals("")){
			JOptionPane.showMessageDialog(document, MyApp.getInstance().getResourceBundle().getString("mustName"));
			
		}
		else{
			Dokument dokument = new Dokument(ime);
			dokument.addObserver(MyApp.getInstance().getModelTree());
			dokument.setParent(MyApp.getInstance().getProject());//vraca aktivni projekat
			MyApp.getInstance().getProject().AddDocument(dokument);   
			
		   document.setVisible(false);
		}
		
		
	
		
	}
	
}
