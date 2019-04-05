package actions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import app.MyApp;
import model.Project;

public class AddingProject  implements ActionListener{
	private JTextArea setname;
	private JFrame proj;
	public  AddingProject(JTextArea jte, JFrame frame){
    
		this.setname=jte;
		this.proj=frame;
		};
		
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String ime = setname.getText();
		if(ime.equals("")){
			JOptionPane.showMessageDialog(proj, MyApp.getInstance().getResourceBundle().getString("mustName"));				
		}
		else{
			Project p = new Project(ime);
			p.addObserver(MyApp.getInstance().getModelTree());
			p.setParent(MyApp.getInstance().getWorkspace());//vraca aktivni workspace
			MyApp.getInstance().getWorkspace().dodajProjekat(p);	   
			proj.setVisible(false);
		  
		}
		
	}
}
