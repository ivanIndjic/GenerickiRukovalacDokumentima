package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import actions.ChangeActionListener;
import app.MyApp;
import model.AbstractCollection;

public class ChangeDialog {

	JFrame proj=new JFrame(MyApp.getInstance().getResourceBundle().getString("viewChangeName"));
	
	public ChangeDialog() {
	
	Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
	AbstractCollection p = (AbstractCollection) o;
	
	JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("name"));
		
	
	JTextArea setname = new JTextArea(p.getName());
	
	setname.setPreferredSize(new Dimension(300,23));
	addname.setSize(100,30);
	JPanel data = new JPanel( new BorderLayout());
	JButton OKbut = new JButton(MyApp.getInstance().getResourceBundle().getString("Change"));
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
    proj.setLocationRelativeTo(null);
	proj.setVisible(true);
	
	
	
	OKbut.addActionListener(new ChangeActionListener(setname,proj,p));
}
	
	
	
	
}

