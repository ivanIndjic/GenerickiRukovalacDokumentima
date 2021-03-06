package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import actions.AddingElement;
import app.MyApp;

public class ElementWindow {
	  public ElementWindow(){
			JFrame document = new JFrame(MyApp.getInstance().getResourceBundle().getString("element"));
			JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("content"));
			JTextArea setname = new JTextArea();
			setname.setPreferredSize(new Dimension(300,300));
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
			document.add(data);
			document.setSize(500, 300);
			document.setLocationRelativeTo(null);
			document.setVisible(true);
			OKbut.addActionListener(new AddingElement(setname, document));
			
	   }
}
