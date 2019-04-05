package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import actions.AddingProject;
import app.MyApp;

public class ProjectWindow {
public ProjectWindow(){
		
		JFrame proj = new JFrame(MyApp.getInstance().getResourceBundle().getString("project"));
		
		JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("nameProject"));
		JTextArea setname = new JTextArea();
		setname.setPreferredSize(new Dimension(300,23));
		addname.setSize(100,30);
		JPanel data = new JPanel( new BorderLayout());
	     
		JButton OKbut = new JButton(MyApp.getInstance().getResourceBundle().getString("add"));
		OKbut.setSize(30, 30);
		JPanel dugme = new JPanel();
		JPanel ime = new JPanel();
		JPanel setIme = new JPanel();
		ime.add(setname);
		setIme.add(addname);
		dugme.add(OKbut);
		data.add(dugme,BorderLayout.SOUTH);
		data.add(ime,BorderLayout.EAST);
		data.add(setIme,BorderLayout.WEST);
		proj.add(data);
		proj.setSize(500, 300);
		proj.setPreferredSize(new Dimension(500, 300));
	    proj.setLocationRelativeTo(null);
		proj.setVisible(true);
		OKbut.addActionListener(new AddingProject(setname, proj));
	
}


}
